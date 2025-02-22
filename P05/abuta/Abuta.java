package abuta;
import java.util.List;



import java.util.ArrayList;
import menu.Menu;
import menu.MenuItem;
import account.Account;
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

}
