package fr.tmaurier.banking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {

    public double balance;
    public List<Transaction> transactions;

    public Account(double balance) {
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        addTransaction(new Transaction(amount, new Date(), balance, true));
    }

    public void withdraw(double amount) {
        balance -= amount;
        addTransaction(new Transaction(amount, new Date(), balance, false));
    }

    public void printStatement() {

        String transactionsToPrint = transactions.stream()
                .map(this::buildTransactionsToPrint)
                .reduce("Date           Amount          Balance", String::concat);
        System.out.println(transactionsToPrint);
    }

    private String buildTransactionsToPrint(Transaction transaction) {
        return "\n" + transaction.getDate() + "     " + transaction.getAmount() + "         " + transaction.getBalance();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }


}
