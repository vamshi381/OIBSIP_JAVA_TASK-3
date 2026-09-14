package atm;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final String accountId;
    private final String name;
    private final int pin;
    private double balance;

    private final List<Transaction> transactions;

    public Account(String accountId, String name, int pin, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;

        transactions.add(
                new Transaction(
                        "DEPOSIT",
                        amount,
                        "Cash deposited"
                )
        );

        return true;
    }

    public boolean withdraw(double amount) {

        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;

        transactions.add(
                new Transaction(
                        "WITHDRAW",
                        amount,
                        "Cash withdrawn"
                )
        );

        return true;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        return "Account ID: " + accountId
                + ", Name: " + name
                + ", Balance: ₹" + String.format("%.2f", balance);
    }
}