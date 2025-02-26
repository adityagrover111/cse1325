package message;

import account.Account;
import account.AccountStatus;
import java.util.Date;
import java.util.ArrayList;

/**
 * represents message that can be sent from an account. also has a functionality
 * to reply.
 * 
 * @author Aditya Grover
 * @since 1.0
 * @version 1.0
 */
public class Message {
    protected Account from;
    protected Date date;
    protected Message repliedTo;
    protected ArrayList<Message> replies;
    protected String body;

    /**
     * Creates a new message
     * 
     * @param from      the sender of the message
     * @param repliedTo the message thats being replied to
     * @param body      contens of the message
     * @since 1.0
     */
    public Message(Account from, Message repliedTo, String body) {
        this.from = from;
        this.repliedTo = repliedTo;
        this.body = body;
        this.date = new Date();
        this.replies = new ArrayList<>();

        if (repliedTo != null) {
            repliedTo.addReply(this);
        }
    }
    
    public int getNumReplies() {
        return replies.size();
    }
    

    /**
     * adds a reply to a message
     * 
     * @param reply
     * @since 1.0
     */

    private void addReply(Message reply) {
        replies.add(reply);
    }

    /**
     * retrieves the message that this message is replying to
     * 
     * @return the replied to message, or null if it's an original message
     * @since 1.0
     */
    public Message getRepliedTo() {
        return repliedTo;
    }

    /**
     * gets the reply to a message at specific index
     * 
     * @param index
     * @return null if index invalid or returns the reply at a specific index
     */

    public Message getReply(int index) {
        if (index >= replies.size() || index < 0)
            return null;
        else
            return replies.get(index);

    }

    /**
     * eturns the string representation of the message with the date, sender,
     * replies and body.
     * 
     * @return a string representation of the message
     * @since 1.0
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Date: ").append(date).append("\n");
        sb.append("From: ").append(from).append("\n");

        if (repliedTo != null) {
            sb.append("In reply to: ").append(repliedTo.from).append("\n");
        }

        if (replies.size() > 0) {
            sb.append("Replies: ");
            for (int i = 0; i < replies.size(); i++) {
                if (i > 0)
                    sb.append(", ");
                sb.append("[").append(i).append("] ").append(replies.get(i).from);
            }
            sb.append("\n");
        }

        sb.append(body);
        return sb.toString();
    }

}
