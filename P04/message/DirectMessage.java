package message;

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
