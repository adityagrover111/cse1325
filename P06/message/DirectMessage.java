package message;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import account.Account;

/**
 * represents direct message from one account to another
 * 
 * @author Aditya Grover
 * @since 1.0
 * @version 1.0
 */
public class DirectMessage extends Message {
    private Account to;

    /**
     * creates a DirectMessage with specified sender, recipient, original message
     * (if replying), and body
     *
     * @param from      the account sending the message
     * @param to        the account receiving the message
     * @param repliedTo the original message being replied to
     * @param body      the content of the message
     * @since 1.0
     */
    public DirectMessage(Account from, Account to, Message repliedTo, String body) {
        super(from, repliedTo, body);
        this.to = to;
    }

     public DirectMessage(BufferedReader br, Message repliedTo) throws IOException {
        super(br, repliedTo); 
        this.to = new Account(br); 
    }

     @Override
    public void save(BufferedWriter bw) throws IOException {
        bw.write(getClass().getName() + "\n");
        super.save(bw); 
        to.save(bw); 
    }

    /**
     * returns the string representation of the direct message.
     * 
     * @return the formatted string representing the direct message
     * @since 1.0
     */
    public String toString() {
        return "To: " + to + " " + super.toString();
    }
}
