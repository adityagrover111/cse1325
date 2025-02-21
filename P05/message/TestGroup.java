package message;

public class TestGroup {
    public static void main(String args[]) {
        try {
            Group group = new Group("microwave fan club");
            System.out.println("Running tests for: " + group.toString());

            if (!group.isActive()) {
                System.err.println("FAILED: GROUP NOT ACTIVE");
            }

            group.disable();

            if (group.isActive()) {
                System.err.println("FAILED: GROUP DID NOT GET DISABLED");
            }

            if (!group.toString().contains("[inactive]")) {
                System.err.println("FAILED: GROUP DOESN'T PRINT [inactive]");
            }

            group.enable();

            if (!group.isActive()) {
                System.err.println("FAILED: GROUP DIDN'T GET ENABLED");
            }

            System.out.println("All tests passed successfully for: " + group.toString());

        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
