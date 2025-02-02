import java.util.ArrayList;
import java.util.Scanner;

public class DemoMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("jam"));
        accounts.add(new Account("sam"));
        accounts.add(new Account("bethany"));
        accounts.add(new Account("george"));
        
        System.out.print("Enter message body: ");
        String body = scanner.nextLine();
        
        System.out.print("Enter sender name (available senders: sam, jam, bethany, george): ");
        String senderName = scanner.nextLine().trim();
        
        Account sender = null;
        
        if (senderName.equals("jam")) {
            sender = accounts.get(0);
        } else if (senderName.equals("sam")) {
            sender = accounts.get(1);
        } else if (senderName.equals("bethany")) {
            sender = accounts.get(2);
        } else if (senderName.equals("george")) {
            sender = accounts.get(3);
        } else {
            System.out.println("sender name is invalid");
            scanner.close();
            return;
        }
        
        Message message = new Message(sender, null, body);
        System.out.println("\nabUTA YOU™:");
        System.out.println("Message Created:");
        System.out.println(message);
        
        scanner.close();
    }
}
