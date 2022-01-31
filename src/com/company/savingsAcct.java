package com.company;

/**
 * Raymond Guerrero
 * Assignment 5
 * CSC122
 *
 * Create a bankaccount, checking, and savings account
 * with interest rate and user compatibility
 *
 * I built this with help from:
 * General Help:
 *  https://docs.oracle.com/en/java/
 *
 *  On Polymorphism:
 *  https://docs.microsoft.com/en-us/dotnet/csharp/fundamentals/object-oriented/polymorphism
 */
//Savings account child class
//has interest rate
//method to apply interest = profit
public class savingsAcct extends bankAccount {
    //interest rate
    private double interestRate;

    public savingsAcct(){
        super();
    }

    // this constructor passes savings acct with
    // custom Account num and interest rate
    public savingsAcct(int accountNum,double interestRate ){
        super(accountNum);
       this.interestRate = interestRate;
    }

    //getter function
    public double getInterestRate(){
        return this.interestRate;
    }

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }
    //how much acct has earned based on balance
    public double calcInterest(){
        return balance * interestRate;

    }

    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Interest amount %.2f added to balance%n", interest);
        deposit(calcInterest());
    }



    //Function to deposit funds into account
    //must be > 0

    @Override
    public double deposit(double amount) {

        //check amt
        if (amount > 0) {
            balance += amount;
            System.out.printf("amount %.2f deposited%n", amount);
            System.out.printf("Current Balance is %.2f%n", balance);
        } else {
            System.out.println("Cannot deposit negative amount");
        }


        return amount;
    }
    //Function to withdraw into acct
    // must be > 0  and amt withdraw be <= balance
    public double withdraw(double amount){

        //check
        if(amount > 0){

            if((amount)<=balance){

                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                System.out.printf("Current balance is %.2f%n", balance);

            }

        }else{
            System.out.println("Negative amount cannot be withdrawn");
        }


        return amount;
    }
}
