package message;
import account.Account;

public class Post extends Message {
    private Group group;

    public Post(Account from, Group group, Message repliedTo, String body){
        super(from, repliedTo, body);
        this.group=group;
    }

    @Override
    public String toString(){
        return "group: " + group + "\n" + super.toString();
    }
}
