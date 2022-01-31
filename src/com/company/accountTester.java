package com.company;
import java.util.*;

public class accountTester extends bankAccount {
    //Start of program
    public static void main(String[] args) {

        Scanner atm = new Scanner(System.in);
        //create array of accounts
        bankAccount account[] = new bankAccount[10];
        int numAccounts = 0;
        int choice;

        do {
            choice = menu(atm);
            System.out.println();

            if (choice == 1) {
                account[numAccounts++] = createAcct(atm);
            } else if (choice == 2) {
                doDeposit(account, numAccounts, atm);
            } else if (choice == 3) {
                doWithdraw(account, numAccounts, atm);
            } else if (choice == 4) {
                applyInterest(account, numAccounts, atm);
            } else {
                System.out.println("Goodbye!");
            }

            System.out.println();
        } while (choice != 5);
    }

    //Account choice
    //sub menu
    public static int accountMenu(Scanner atm) {
        System.out.println("Select Account Type: ");
        System.out.println("1. Checking Acct ");
        System.out.println("2. Savings Acct ");
        int choice;
        do {
            System.out.print("Enter choice: ");
            choice = atm.nextInt();
        } while (choice < 1 || choice > 2);
        return choice;
    }

    public static int searchAccount(bankAccount account[], int count, int accountNum) {

        for (int i = 0; i < count; i++) {
            if (account[i].getAccountNum() == accountNum) {
                return i;
            }
        }

        return -1;
    }

    //Function to perform deposits on selected account
    public static void doDeposit(bankAccount account[], int count, Scanner atm) {
        //Get Acct Number
        System.out.print("\n Please enter account number: ");
        int accountNum = atm.nextInt();

        //Search for accounts
        int index = searchAccount(account, count, accountNum);

        if (index >= 0) {
            //amount
            System.out.print("Please enter deposit amount: ");
            double amount = atm.nextDouble();

            account[index].deposit(amount);
        } else {
            System.out.println("No account found with that number" + accountNum);
        }
    }


    public static void doWithdraw(bankAccount account[], int count, Scanner atm) {
        //Get Acct Number
        System.out.print("\n Please enter account number: ");
        int accountNum = atm.nextInt();

        //Search for accounts
        int index = searchAccount(account, count, accountNum);

        if (index >= 0) {
            //amount
            System.out.print("Please enter withdrawal amount: ");
            double amount = atm.nextDouble();

            account[index].withdraw(amount);
        } else {
            System.out.println("No account found with that number" + accountNum);
        }
    }

    public static void applyInterest(bankAccount account[], int count, Scanner atm) {
        //Get Acct Number
        System.out.print("\n Please enter account number: ");
        int accountNum = atm.nextInt();

        //Search for accoutns
        int index = searchAccount(account, count, accountNum);

        if (index >= 0) {
            // must be an instance of savings account
            if (account[index] instanceof savingsAcct) {
                ((savingsAcct) account[index]).applyInterest();
            }

            //account[index].applyInterest(amount);
        } else {
            System.out.println("No account found with that number: " + accountNum);
        }
    }

    //Function to create new account
    public static bankAccount createAcct(Scanner atm) {

        bankAccount account = null;
        int choice = accountMenu(atm);

        int accountNum;
        System.out.print("Enter Account Number: ");
        accountNum = atm.nextInt();

        if (choice == 1) {// checking account
            System.out.print("Enter Service Charge: ");
            double servCharge = atm.nextDouble();
            account = new checkingAcct(accountNum, servCharge);

        } else {//Savings account
            System.out.print("Please enter Interest Rate: ");
            double ir = atm.nextDouble();
            account = new savingsAcct(accountNum, ir);
        }
        return account;

    }


    //Menu to offer options and receive user selections
    public static int menu(Scanner atm) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create new account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");
        int choice;

        do {
            System.out.print("Enter choice: ");
            choice = atm.nextInt();
        } while (choice < 1 || choice > 5);
        return choice;
    }

    @Override
    public double withdraw(double amount) {

        return amount;
    }

    @Override
    public double deposit(double amount) {

        return amount;
    }
}