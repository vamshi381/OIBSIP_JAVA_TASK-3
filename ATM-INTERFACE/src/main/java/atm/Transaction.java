package atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private final String type;
    private final double amount;
    private final String description;
    private final LocalDateTime dateTime;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.dateTime = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return "Type        : " + type
                + "\nAmount      : ₹" + String.format("%.2f", amount)
                + "\nDescription : " + description
                + "\nDate & Time : " + dateTime.format(formatter);
    }
}