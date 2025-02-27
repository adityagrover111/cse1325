package abuta;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import menu.Menu;
import menu.MenuItem;
import account.Account;
import message.DirectMessage;
import message.Group;
import message.Message;
import message.Post;

/**
 * Main application class for Abuta social platform.
 * 
 * @author Aditya Grover
 * @since 1.0
 * @version 1.0
 */
public class Abuta {
    private List<Account> accounts;
    private List<Group> groups;
    private Message message;
    private Menu menu;
    private String output;
    private boolean running;
    private String filename;

    public Abuta() {
        accounts = new ArrayList<>();
        groups = new ArrayList<>();
        output = "";
        filename = "abuta_save.txt";

        accounts.add(new Account("Aditya"));
        accounts.add(new Account("Fred"));
        accounts.add(new Account("George"));
        accounts.add(new Account("Harry"));
        accounts.add(new Account("Ron"));

        groups.add(new Group("Microwave Fans"));
        groups.add(new Group("Computer Science Enthusiasts"));
        groups.add(new Group("Mcdonalds Rocks"));
        groups.add(new Group("Gym"));
        groups.add(new Group("Chipotle Lovers"));

        newAbuta();

        menu = new Menu();
        menu.addMenuItem(new MenuItem("Exit", () -> endApp()));
        menu.addMenuItem(new MenuItem("New Abuta", () -> newAbuta()));
        menu.addMenuItem(new MenuItem("Show Reply", () -> showReply()));
        menu.addMenuItem(new MenuItem("Show Replied To", () -> showRepliedTo()));
        menu.addMenuItem(new MenuItem("Add Reply", () -> reply()));
        menu.addMenuItem(new MenuItem("Create New Account", () -> createAccount()));
        menu.addMenuItem(new MenuItem("Create New Group", () -> createGroup()));
        menu.addMenuItem(new MenuItem("Save", () -> save()));
        menu.addMenuItem(new MenuItem("Save As", () -> saveAs()));
        menu.addMenuItem(new MenuItem("Open", () -> open()));
    }

    private void newAbuta() {
        message = new Post(accounts.get(0), groups.get(0), null, "Welcome to Microwave Fans.");
    }

    private void save() {
        if (filename == null) {
            output = "No file name is set. Use Save As first to save a file.";
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            Message root = getRootMessage();
            bw.write(root.getClass().getName() + "\n");
            root.save(bw);
            output = "File successfully saved as " + filename;
        } catch (IOException e) {
            output = "Failed to save: " + e.getMessage();
            e.printStackTrace();
        }
    }

    private void saveAs() {
        String newFilename = Menu.getString("Enter filename to save as: ");
        if (newFilename != null && !newFilename.isEmpty()) {
            filename = newFilename;
            save();
        } else {
            output = "Invalid filename.";
        }
    }

    private void open() {
        String newFile = Menu.getString("Enter filename to open: ");
        if (newFile == null || newFile.isEmpty()) {
            output = "Invalid filename.";
            return;
        }

        filename = newFile;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String messageType = br.readLine();
            if (messageType.equals("message.Post")) {
                message = new Post(br, null);
            } else if (messageType.equals("message.DirectMessage")) {
                message = new DirectMessage(br, null);
            } else {
                throw new IOException("Unknown message type: " + messageType);
            }
            output = "Loaded successfully from " + filename;
        } catch (IOException e) {
            output = "Failed to open: " + e.getMessage();
            e.printStackTrace();
        }
    }

    private Message getRootMessage() {
        Message root = message;
        while (root.getRepliedTo() != null) {
            root = root.getRepliedTo();
        }
        return root;
    }

    public void mdi() {
        running = true;
        while (running) {
            try {
                System.out.println("\n            - = #abUTA You- = #\n");
                System.out.println(menu);
                System.out.println(message);
                System.out.println(output);
                output = "";
                int choice = Menu.getInt("Selection: ");
                menu.run(choice);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void endApp() {
        running = false;
    }

    private void showRepliedTo() {
        if (message.getRepliedTo() == null) {
            output = "No message was replied to.";
        } else {
            message = message.getRepliedTo();
        }
    }

    private void showReply() {
        if (message.getNumReplies() == 0) {
            output = "No replies to show.";
        } else if (message.getNumReplies() == 1) {
            message = message.getReply(0);
        } else {
            int index = Menu.getInt("Which reply (0-" + (message.getNumReplies() - 1) + ")? ");
            if (index >= 0 && index < message.getNumReplies()) {
                message = message.getReply(index);
            } else {
                output = "Invalid reply number.";
            }
        }
    }

    private void reply() {
        try {
            char type = Menu.getChar("Post or Direct Message (p/d): ");

            int authorIndex = Menu.selectItemFromList("Select author: ", accounts);
            Account author = accounts.get(authorIndex);

            if (type == 'p' || type == 'P') {
                int groupIndex = Menu.selectItemFromList("Select group: ", groups);
                Group group = groups.get(groupIndex);
                String text = Menu.getString("Enter post text: ");
                message = new Post(author, group, message, text);
            } else if (type == 'd' || type == 'D') {
                int recipientIndex = Menu.selectItemFromList("Select recipient: ", accounts);
                Account recipient = accounts.get(recipientIndex);
                String text = Menu.getString("Enter message text: ");
                message = new DirectMessage(author, recipient, message, text);
            }
        } catch (Exception e) {
            output = e.getMessage();
        }
    }

    private void createAccount() {
        String name = Menu.getString("Enter new account name: ");
        accounts.add(new Account(name));
        output = "New account " + name + " created successfully";
    }

    private void createGroup() {
        String name = Menu.getString("Enter new group name: ");
        groups.add(new Group(name));
        output = "New group " + name + " created successfully";
    }

    public static void main(String[] args) {
        Abuta app = new Abuta();
        app.mdi();
    }
}
