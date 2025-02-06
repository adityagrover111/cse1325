package message;
import account.Account;
import account.AccountStatus;
import java.util.Date;
import java.util.ArrayList;

public class Message {
    protected Account from;
    protected Date date;
    protected Message repliedTo;
    protected ArrayList<Message> replies;
    protected String body;

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

    private void addReply(Message reply) {
        replies.add(reply);
    }

    public Message getRepliedTo() {
        return repliedTo;
    }

    public Message getReply(int index) {
        if (index >= replies.size() || index < 0)
            return null;
        else
            return replies.get(index);

    }

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
                sb.append(replies.get(i).from);
            }
            sb.append("\n");
        }

        sb.append(body);
        return sb.toString();
    }

}
