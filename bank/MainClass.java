package bank;

import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        
        BankAccount bankAccount1 = new BankAccount("Second account",123566);
        bankAccount1.deposit(13021);
        bankAccount1.deposit(13021);
        System.out.println("Your bank account contains: "+bankAccount1.getAmount());
        
        System.out.println("***Withdraw***");
        bankAccount.withdraw(42.4);
        bankAccount.withdraw(42.4);
        bankAccount.withdraw(42.4);
        System.out.println("Your bank account contains: "+bankAccount.getAmount());
        
        bankAccount.printAccountDetails();
        bankAccount.printTransactions();
        
        System.out.println(BankAccount.accountsCreated);
    }

}
