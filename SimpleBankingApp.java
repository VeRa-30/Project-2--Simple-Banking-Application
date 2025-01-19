import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    // Get account holder name
    public String getAccountHolder() {
        return accountHolder;
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Amount must be greater than 0.");
        }
    }

    // Withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Amount must be greater than 0.");
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }
}
public class SimpleBankingApp {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Show menu options
            System.out.println("==== Welcome to Simple Banking ====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Exiting the application. Thank you for using Simple Banking!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to create a new account
    private static void createAccount() {
        System.out.print("Enter the name of the account holder: ");
        String accountHolder = scanner.nextLine();
        BankAccount account = new BankAccount(accountHolder);
        accounts.add(account);
        System.out.println("Account created successfully for " + accountHolder);
    }

    // Method to deposit money
    private static void depositMoney() {
        System.out.print("Enter the account holder name to deposit money: ");
        String accountHolder = scanner.nextLine();

        BankAccount account = findAccount(accountHolder);
        if (account != null) {
            System.out.print("Enter the amount to deposit: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to withdraw money
    private static void withdrawMoney() {
        System.out.print("Enter the account holder name to withdraw money: ");
        String accountHolder = scanner.nextLine();

        BankAccount account = findAccount(accountHolder);
        if (account != null) {
            System.out.print("Enter the amount to withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to check balance
    private static void checkBalance() {
        System.out.print("Enter the account holder name to check balance: ");
        String accountHolder = scanner.nextLine();

        BankAccount account = findAccount(accountHolder);
        if (account != null) {
            System.out.println("Current balance for " + accountHolder + ": " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to find account by account holder name
    private static BankAccount findAccount(String accountHolder) {
        for (BankAccount account : accounts) {
            if (account.getAccountHolder().equalsIgnoreCase(accountHolder)) {
                return account;
            }
        }
        return null;
    }
}

