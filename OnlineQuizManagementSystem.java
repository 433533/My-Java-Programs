import java.util.Scanner;


public class OnlineQuizManagementSystem {
    // Sample username and password
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // User login
        System.out.println("Welcome to Online Quiz Management System");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }
        
        // Test configuration
        System.out.println("Login successful. Test Configuration:");
        System.out.print("Enter unique key for the test: ");
        String uniqueKey = scanner.nextLine();
        System.out.print("Enter number of questions: ");
        int numQuestions = scanner.nextInt();
        System.out.print("Enter time duration (in minutes): ");
        int timeDuration = scanner.nextInt();
        
        // Start the test
        System.out.println("\nTest will start now...");
        // Code to start the test and display questions
        
        // Simulating test completion
        System.out.println("\nTest completed!");
        // Code to review answers and calculate score
        
        // Simulating submitting the test
        System.out.println("\nDo you want to submit the test? (yes/no)");
        String submitChoice = scanner.next();
        if (submitChoice.equalsIgnoreCase("yes")) {
            // Code to submit the test and display result
            System.out.println("Test submitted successfully. Thank you!");
        } else {
            System.out.println("Test not submitted. Thank you!");
        }
        
        scanner.close();
    }
}
