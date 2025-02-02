import java.util.ArrayList;
import java.util.Scanner;

public class DemoMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("jam"));
        accounts.add(new Account("sam"));
        
        System.out.print("Enter message body: ");
        String body = scanner.nextLine();
        
        System.out.print("Enter sender name (available senders: sam and jam): ");
        String senderName = scanner.nextLine().trim();
        
        Account sender = null;
        if (senderName.equals("jam")) {
            sender = accounts.get(0);
        } else if (senderName.equals("sam")) {
            sender = accounts.get(1);
        }
        
        if (sender != null) {
            Message message = new Message(sender, null, body);
            System.out.println("\nMessage Created:");
            System.out.println(message);
        } else {
            System.out.println("Invalid sender name!");
        }
        
        scanner.close();
    }
}
