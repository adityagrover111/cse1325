package message;
import account.Account;
/**
 * depicts a post of an account
 * @author Aditya Grover
 * @version 1.0
 * @since 1.0
 */
public class Post extends Message {
    private Group group;

    /**
     * creates a Post stating account that posted it and other details
     * @param from the account that posted
     * @param group group that it was posted to
     * @param repliedTo the message the post repliedTo
     * @param body content of the post
     * @since 1.0
     */
    public Post(Account from, Group group, Message repliedTo, String body){
        super(from, repliedTo, body);
        this.group=group;
    }
/**
 * returns the string representation of the post
 * @return String the representation with group name and contents
 * @since 1.0
 */
    @Override
    public String toString(){
        return "group: " + group + "\n" + super.toString();
    }
}
