import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a new BankAccount object
        // The BankAccount constructor is called to initialize the account with values
        BankAccount bankAccount = new BankAccount(123123123, "Rashmina Fernando", 1500.00);

        // Scanner object to take user input for the menu choices
        Scanner scanner = new Scanner(System.in);

        // Flag to control the while loop for the main menu
        boolean running = true;

        // Main menu loop, runs until the user chooses to exit (option 4)
        while (running) {
            // Display the main menu
            System.out.println("****************************");
            System.out.println(" Welcome to the banking app ");
            System.out.println("****************************");
            System.out.println("Press 1 to check your account balance");
            System.out.println("Press 2 to withdraw");
            System.out.println("Press 3 to deposit");
            System.out.println("Press 4 to Exit");
            System.out.print("Enter (1/2/3/4): ");

            // Take user input to choose an option from the menu
            int choice = scanner.nextInt();

            // Switch statement for handling different menu options
            switch (choice) {
                case 1:
                    // Display the current balance by calling the getter method of the BankAccount object
                    System.out.println("Balance: " + bankAccount.getBalance());
                    break;
                case 2:
                    // Call the withdraw method to withdraw money
                    bankAccount.withdraw();
                    break;
                case 3:
                    // Call the deposit method to deposit money
                    bankAccount.deposit();
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Bye bye....");
                    running = false;  // Set flag to false to exit the while loop
                    break;
                default:
                    // If the user enters an invalid option, show an error message
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        // Close the scanner to release system resources
        scanner.close();
    }
}
