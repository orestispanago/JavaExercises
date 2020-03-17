package bank;

import java.util.ArrayList;

public class BankAccount {

    private int number;
    private double amount;
    private String name;
    private boolean active;
    private ArrayList<String> transactions;
    static int accountsCreated = 0;

    public BankAccount() {
        System.out.println("Created default bank account");
        this.active = true;
        ArrayList<String> transactions = new ArrayList();
        transactions.add("Created");
        this.transactions = transactions;
        accountsCreated++;
    }

    public BankAccount(String name, int number) {
        System.out.println("Created bank account "+name+", "+number);

        this.name = name;
        this.number = number;
        this.active = true;
        ArrayList<String> transactions = new ArrayList();
        transactions.add("Created");
        this.transactions = transactions;
        accountsCreated++;

    }

    public BankAccount(int number, double amount, String name) {
        System.out.println("Created bank account "+name+", "+number);

        this.number = number;
        this.amount = amount;
        this.name = name;
        this.active = true;
        ArrayList<String> transactions = new ArrayList();
        transactions.add("Created");
        this.transactions = transactions;
        accountsCreated++;

    }

    //Setters
    public void setNumber(int number) {
        this.number = number;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTransactions(ArrayList<String> transactions) {
        this.transactions = transactions;
    }

    //Getters
    public int getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }

    public void printAccountDetails() {
        System.out.println("*****Account details*****");
        System.out.println("Account name: " + getName());
        System.out.println("Account #: " + getNumber());
        System.out.println("Active : " + isActive());
        System.out.println("Balance : " + getAmount());
    }

    public void deposit(double amount) {
        double newAmount = getAmount() + amount;
        setAmount(newAmount);
        System.out.printf("Deposited %f\n", amount);
        String deposit = String.format("Deposit: %f", amount);
        storeAction(deposit);
    }

    public void withdraw(double amount) {
        if (getAmount() > amount) {
            double newAmount = getAmount() - amount;
            setAmount(newAmount);
            System.out.printf("Withdraw %f from your account.\n", amount);
            String withdrawal = String.format("Withdrawal: %f", amount);
            storeAction(withdrawal);
        } else {
            System.out.println("You don't have enough money...transaction canceled");
        }
    }

    public void storeAction(String action) {
        ArrayList<String> actions = getTransactions();
        actions.add(action);
        setTransactions(actions);
    }

    public void printTransactions() {
        ArrayList<String> actions = getTransactions();
        System.out.println("***Account transactions***");
        for (String action : actions) {
            System.out.println(action);
        }
    }
}
