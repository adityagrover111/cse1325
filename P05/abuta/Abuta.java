package abuta;
import java.util.List;



import java.util.ArrayList;
import menu.Menu;
import menu.MenuItem;
import account.Account;
import message.DirectMessage;
import message.Group;
import message.Message;
import message.Post;



public class Abuta {
    private List<Account> accounts;
    private List<Group> groups;
    private Message message;
    private Menu menu;
    private String output;
    private boolean running;

    public Abuta(){
        accounts=new ArrayList<>();
        groups=new ArrayList<>();

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
    
        message = new Post(accounts.get(0), groups.get(0),null,"Welcome to Microwave Fans.");  
        
        menu = new Menu();
        menu.addMenuItem(new MenuItem("Exit", () -> endApp()));
        menu.addMenuItem(new MenuItem("Show Reply", () -> showReply()));
        menu.addMenuItem(new MenuItem("Show Replied To", () -> showRepliedTo()));
        menu.addMenuItem(new MenuItem("Add Reply", () -> reply()));
    }

    public void mdi(){
        running=true;
        while(running){
            try{
                System.out.println("abUTA You");
                System.out.println(menu);
                System.out.println(message);
                System.out.println(output);
                output = "";
                int choice = Menu.getInt("Choice? ");
                menu.run(choice);
            }
            catch(Exception e){
                System.out.println("e.getMessage()");
            }
        }
    }

    private void endApp(){
        running=false;
    }

    private void showRepliedTo(){
        if(message.getRepliedTo()==null){
            output="no message was replied to ";
        }
        else
        message=message.getRepliedTo();
    }
    
    private void showReply(){
        if(message.getNumReplies()==0){
            output="no replies to show";
        }
        else if(message.getNumReplies()==1){
            message=message.getReply(0);
        }
        else{
            int index = Menu.getInt("Which reply (0-" + (message.getNumReplies()-1) + ")? ");
            if(index >= 0 && index < message.getNumReplies()) {
                message = message.getReply(index);
            } else {
                output = "Invalid reply number";
            }
        }

        }

        private void reply(){
             try {
            char type = Menu.getChar("Post or Direct Message (p/d)? ");
            
            int authorIndex = Menu.selectItemFromList("Select author", accounts);
            Account author = accounts.get(authorIndex);
            
            if(type == 'p' || type == 'P') {
                int groupIndex = Menu.selectItemFromList("Select group", groups);
                Group group = groups.get(groupIndex);
                String text = Menu.getString("Enter post text: ");
                message = new Post(author, group, message, text);
            } else if(type == 'd' || type == 'D') {
                int recipientIndex = Menu.selectItemFromList("Select recipient", accounts);
                Account recipient = accounts.get(recipientIndex);
                String text = Menu.getString("Enter message text: ");
                message = new DirectMessage(author, recipient, message, text);
            }
        } catch(Exception e) {
            output = "Error creating reply: " + e.getMessage();
        }
        }
    }
    







    
