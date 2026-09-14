package atm;

import java.util.List;
import java.util.Scanner;

public class ATM {

    private final Bank bank;
    private final Scanner scanner;

    private Account currentAccount;

    private static final int MAX_LOGIN_ATTEMPTS = 3;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void start() {

        displayWelcomeMessage();

        boolean loggedIn = login();

        if (!loggedIn) {

            System.out.println();
            System.out.println("Too many incorrect attempts.");
            System.out.println("Your access has been denied.");
            System.out.println("Thank you for using the ATM.");

            scanner.close();
            return;
        }

        showMainMenu();

        scanner.close();
    }

    private void displayWelcomeMessage() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("           WELCOME TO ATM");
        System.out.println("==========================================");
    }

    private boolean login() {

        for (int attempt = 1; attempt <= MAX_LOGIN_ATTEMPTS; attempt++) {

            System.out.println();
            System.out.println("Login Attempt " + attempt
                    + " of " + MAX_LOGIN_ATTEMPTS);

            System.out.print("Enter User ID: ");
            String accountId = scanner.nextLine().trim();

            int pin = readPin();

            Account account = bank.authenticate(accountId, pin);

            if (account != null) {

                currentAccount = account;

                System.out.println();
                System.out.println("Login successful!");
                System.out.println("Welcome, "
                        + currentAccount.getName() + "!");

                return true;
            }

            System.out.println();
            System.out.println("Invalid User ID or PIN.");

            if (attempt < MAX_LOGIN_ATTEMPTS) {

                System.out.println(
                        "Please try again."
                );
            }
        }

        return false;
    }

    private int readPin() {

        while (true) {

            System.out.print("Enter PIN: ");

            String input = scanner.nextLine().trim();

            try {

                int pin = Integer.parseInt(input);

                if (pin >= 0 && pin <= 9999) {
                    return pin;
                }

                System.out.println(
                        "PIN must contain up to 4 digits."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid PIN. Please enter numbers only."
                );
            }
        }
    }

    private void showMainMenu() {

        while (true) {

            System.out.println();
            System.out.println("==========================================");
            System.out.println("              ATM MENU");
            System.out.println("==========================================");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.println("==========================================");

            int choice = readMenuChoice();

            switch (choice) {

                case 1:
                    showTransactionHistory();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    quit();
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Please select 1 to 5."
                    );
            }
        }
    }

    private int readMenuChoice() {

        while (true) {

            System.out.print("Enter your choice: ");

            String input = scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }

    private void showTransactionHistory() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("         TRANSACTION HISTORY");
        System.out.println("==========================================");

        List<Transaction> transactions =
                currentAccount.getTransactions();

        if (transactions.isEmpty()) {

            System.out.println("No transactions found.");

        } else {

            int count = 1;

            for (Transaction transaction : transactions) {

                System.out.println();
                System.out.println("Transaction " + count);
                System.out.println("------------------------------------------");
                System.out.println(transaction);

                count++;
            }
        }

        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println(
                "Current Balance : ₹"
                        + String.format(
                        "%.2f",
                        currentAccount.getBalance()
                )
        );
        System.out.println("==========================================");
    }

    private void withdraw() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              WITHDRAW");
        System.out.println("==========================================");

        double amount = readAmount(
                "Enter withdrawal amount: ₹"
        );

        if (amount <= 0) {
            return;
        }

        if (amount > currentAccount.getBalance()) {

            System.out.println();
            System.out.println("Insufficient Funds");
            System.out.println(
                    "Available Balance: ₹"
                            + String.format(
                            "%.2f",
                            currentAccount.getBalance()
                    )
            );

            return;
        }

        boolean success = currentAccount.withdraw(amount);

        if (success) {

            System.out.println();
            System.out.println("Withdrawal successful!");
            System.out.println(
                    "Amount Withdrawn: ₹"
                            + String.format("%.2f", amount)
            );
            System.out.println(
                    "Remaining Balance: ₹"
                            + String.format(
                            "%.2f",
                            currentAccount.getBalance()
                    )
            );
        }
    }

    private void deposit() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("               DEPOSIT");
        System.out.println("==========================================");

        double amount = readAmount(
                "Enter deposit amount: ₹"
        );

        if (amount <= 0) {
            return;
        }

        boolean success = currentAccount.deposit(amount);

        if (success) {

            System.out.println();
            System.out.println("Deposit successful!");
            System.out.println(
                    "Amount Deposited: ₹"
                            + String.format("%.2f", amount)
            );
            System.out.println(
                    "New Balance: ₹"
                            + String.format(
                            "%.2f",
                            currentAccount.getBalance()
                    )
            );
        }
    }

    private void transfer() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("              TRANSFER");
        System.out.println("==========================================");

        System.out.print("Enter recipient account ID: ");

        String recipientId = scanner.nextLine().trim();

        if (recipientId.equals(currentAccount.getAccountId())) {

            System.out.println();
            System.out.println(
                    "You cannot transfer money to your own account."
            );

            return;
        }

        Account recipient = bank.findAccount(recipientId);

        if (recipient == null) {

            System.out.println();
            System.out.println(
                    "Recipient account not found."
            );

            return;
        }

        double amount = readAmount(
                "Enter transfer amount: ₹"
        );

        if (amount <= 0) {
            return;
        }

        if (amount > currentAccount.getBalance()) {

            System.out.println();
            System.out.println("Insufficient Funds");
            System.out.println(
                    "Available Balance: ₹"
                            + String.format(
                            "%.2f",
                            currentAccount.getBalance()
                    )
            );

            return;
        }

        /*
         * Deduct money from sender.
         */
        currentAccount.withdraw(amount);

        /*
         * Add money to recipient.
         */
        recipient.deposit(amount);

        /*
         * The deposit() and withdraw() methods already create
         * transactions. We add more descriptive transfer
         * transactions as well and remove the generic ones.
         */

        List<Transaction> senderTransactions =
                currentAccount.getTransactions();

        if (!senderTransactions.isEmpty()) {
            senderTransactions.remove(
                    senderTransactions.size() - 1
            );
        }

        List<Transaction> recipientTransactions =
                recipient.getTransactions();

        if (!recipientTransactions.isEmpty()) {
            recipientTransactions.remove(
                    recipientTransactions.size() - 1
            );
        }

        currentAccount.addTransaction(
                new Transaction(
                        "TRANSFER",
                        amount,
                        "Transferred to Account "
                                + recipient.getAccountId()
                )
        );

        recipient.addTransaction(
                new Transaction(
                        "TRANSFER RECEIVED",
                        amount,
                        "Received from Account "
                                + currentAccount.getAccountId()
                )
        );

        System.out.println();
        System.out.println("Transfer successful!");
        System.out.println(
                "Amount Transferred: ₹"
                        + String.format("%.2f", amount)
        );
        System.out.println(
                "Recipient: "
                        + recipient.getName()
                        + " ("
                        + recipient.getAccountId()
                        + ")"
        );
        System.out.println(
                "Remaining Balance: ₹"
                        + String.format(
                        "%.2f",
                        currentAccount.getBalance()
                )
        );
    }

    private double readAmount(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                double amount = Double.parseDouble(input);

                if (amount <= 0) {

                    System.out.println(
                            "Amount must be greater than zero."
                    );

                    return -1;
                }

                return amount;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid amount. Please enter a valid number."
                );
            }
        }
    }

    private void quit() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("       THANK YOU FOR USING OUR ATM");
        System.out.println("==========================================");
        System.out.println(
                "Goodbye, " + currentAccount.getName() + "!"
        );
        System.out.println(
                "Please take your card and cash."
        );
        System.out.println("==========================================");
    }
}