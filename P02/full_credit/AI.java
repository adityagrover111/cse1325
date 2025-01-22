public class AI {

    private Engine engine;
    private String[] queries;

    public AI(Engine engine) {
        this.engine = engine;
        this.queries = new String[5];
    }

    public String query(String userInput) {
        for (int i = queries.length - 1; i > 0; i--) {
            queries[i] = queries[i - 1];
        }
        queries[0] = userInput;
        return "Answering now: \"" + userInput + "\"";
    }

    public String[] getQueryHistory() {
        return queries;
    }
    
}
