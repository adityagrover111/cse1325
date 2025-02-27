package message;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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

    public Post(BufferedReader br, Message repliedTo) throws IOException {
        super(br, repliedTo); 
        this.group = new Group(br); 
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write(getClass().getName() + "\n"); 
        super.save(bw); 
        group.save(bw); 
    }
/**
 * returns the string representation of the post
 * @return String the representation with group name and contents
 * @since 1.0
 */
    @Override
    public String toString(){
        return "Group: " + group + "\n" + super.toString();
    }
}
