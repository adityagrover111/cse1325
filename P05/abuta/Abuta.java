package abuta;
import java.util.List;

import javax.swing.GroupLayout.Group;

import java.util.ArrayList;
import menu.Menu;
import menu.MenuItem;
import account.Account;
import message.Group;
import message.Message;


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

        groups.add(new Group("cats"));
        

        
    }


}
