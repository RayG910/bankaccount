package com.company;
//child class checking acct
public class checkingAcct extends bankAccount {

    //Service charge for transaction
    private static double servCharge = 2.5;

    //default constructor
    public checkingAcct(){
        super();
    }

    // this constructor passes checking acct with
    // custom Account num and service charge for transaction
    public checkingAcct(int accountNum,double servCharge ){
        super(accountNum);
        servCharge = servCharge;



    }
    //Function to deposit funds into account
    //must be > 0

    @Override
    public double deposit(double amount) {

        //check amt
        if (amount > 0) {
            balance += amount;
            System.out.printf("amount %.2f deposited%n", amount);

            //service charge
            balance -= servCharge;
            System.out.printf("Service charge %.2f applied%n", servCharge);
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

            if((amount+servCharge)<=balance){

                System.out.printf("Amount of %.2f withdrawn from Account%n", amount);
                balance -= amount;
                balance -=servCharge;
                System.out.printf("Service charge of %.2f applied %n", servCharge);
                System.out.printf("Current balance is %.2f%n", balance);

            }

        }else{
            System.out.println("Negative amount cannot be withdrawn");
        }


        return amount;
    }
}
