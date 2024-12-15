import java.util.Scanner;
import java.util.InputMismatchException;

public class BankAccount {
    // Private member variables for encapsulation: These variables cannot be directly accessed outside of the class
    private long accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor: Used to initialize the account with initial values for account number, holder name, and balance
    public BankAccount(long accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getter methods: These are used to access private fields from outside the class.
    // They allow controlled access to the encapsulated data.
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter methods: These allow us to modify the private fields if needed.
    // Although we generally don’t expose setters for sensitive data like account numbers in real systems,
    // in this example, we're showing them for learning purposes.
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Method to deposit money into the account
    public synchronized double deposit() {
        // Scanner object for taking user input
        Scanner scanner = new Scanner(System.in);
        double amount = 0;

        // Asking the user to input the amount they want to deposit
        System.out.println("Enter the amount you want to deposit: ");

        try {
            amount = scanner.nextDouble(); // Take user input for deposit

            // Validation: Ensure the deposit amount is not negative
            if (amount < 0) {
                System.out.println("Amount cannot be negative. Please enter a valid amount.");
                return balance; // Return the unchanged balance
            }
        } catch (InputMismatchException e) {
            // Handle invalid input types
            System.out.println("Invalid input. Please enter a numeric value.");
            return balance; // Return the unchanged balance
        }

        // Update the balance by adding the deposit amount
        balance += amount;
        System.out.println("New Balance: " + balance);
        return balance;
    }

    // Method to withdraw money from the account
    public synchronized double withdraw() {
        Scanner scanner = new Scanner(System.in);
        double amount = 0;
        System.out.println("Enter the amount you want to withdraw: ");

        try {
            amount = scanner.nextDouble(); // Take user input for withdrawal

            // Validation: Ensure the withdrawal amount is not negative
            if (amount < 0) {
                System.out.println("Amount cannot be negative. Please enter a valid amount.");
                return balance;
            }

            // Check if there's enough balance to withdraw
            if (amount > balance) {
                System.out.println("Insufficient balance. Please enter a valid amount.");
                return balance; // Return the unchanged balance
            }
        } catch (InputMismatchException e) {
            // Handle invalid input types
            System.out.println("Invalid input. Please enter a numeric value.");
            return balance; // Return the unchanged balance
        }

        // Update the balance by subtracting the withdrawal amount
        balance -= amount;
        System.out.println("New Balance: " + balance);
        return balance;
    }
}
