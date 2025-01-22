import java.util.Scanner;

public class Query {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("Choose an AI engine:");
            for (Engine e : Engine.values()) {
                System.out.println("- " + e);
            }
            scanner.close();
            return;
        }

        Engine engine = null;
        String userInput = args[0].toUpperCase(); // Convert the input to uppercase for case-insensitive comparison
        if (userInput.equals("PERPLEXITY")) {
            engine = Engine.Perplexity;
        } else if (userInput.equals("CHATGPT")) {
            engine = Engine.ChatGPT;
        } else if (userInput.equals("CLAUDEAI")) {
            engine = Engine.ClaudeAI;
        } else {
            System.out.println("Invalid engine. Choose from: Perplexity, ChatGPT, ClaudeAI.");
            scanner.close();
            return;
        }

        System.out.println("Selected engine: " + engine);

        AI ai = new AI(engine);

        System.out.println("What's your query?");
        while (scanner.hasNextLine()) {
            String query = scanner.nextLine();
            String response = ai.query(query);
            System.out.println(response);
        }

        System.out.println("\nQuery History:");
        for (String query : ai.getQueryHistory()) {
            if (query != null) {
                System.out.println(query);
            }
        }

        scanner.close();
    }
}
