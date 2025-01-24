import java.util.Scanner;

public class Query {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("choose an AI engine: (Enter exactly)");
            for (Engine e : Engine.values()) {
                System.out.println("- " + e);
            }
            scanner.close();
            return;
        }

        Engine engine = null;
        String userInput = args[0];
        if (userInput.equals("Perplexity")) {
            engine = Engine.Perplexity;
        } else if (userInput.equals("ChatGPT")) {
            engine = Engine.ChatGPT;
        } else if (userInput.equals("ClaudeAI")) {
            engine = Engine.ClaudeAI;
        } else {
            System.out.println("choose your ai engine! : Perplexity, ChatGPT, ClaudeAI. (Enter exactly))");
            scanner.close();
            return;
        }

        System.out.println("you have selected: " + engine);

        AI ai = new AI(engine);
        
        System.out.println("ask me anything");
        while (scanner.hasNextLine()) {
        System.out.println("ask me anything");
            String query = scanner.nextLine();
            String response = ai.query(query);
            System.out.println(response);
        }

        System.out.println("\nquery History:");
        for (String query : ai.getQueryHistory()) {
            if (query != null) {
                System.out.println(query);
            }
        }

        scanner.close();
    }
}
