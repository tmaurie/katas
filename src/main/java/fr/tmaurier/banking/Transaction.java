package fr.tmaurier.banking;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Transaction {
    public double amount;
    public Date date;
    private final double balance;
    private final boolean isDeposit;

    public Transaction(double amount, Date date, double balance, boolean isDeposit) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
        this.isDeposit = isDeposit;
    }

    public String getDate() {
        return formatDate();
    }

    public String getAmount() {
        return isDeposit ? "+".concat(formatNumber(amount)) : "-".concat(formatNumber(amount));
    }

    private String formatNumber(double number) {
        return String.format(Locale.US, "%.2f", number);
    }


    private String formatDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(date);

    }

    public String getBalance() {
        return formatNumber(balance);
    }
}
