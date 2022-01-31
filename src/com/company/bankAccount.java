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

//Our base class
//Abstract

public abstract class bankAccount {

    //account number
        protected int accountNum;

        //balance
        protected double balance;

        // constructor
        public bankAccount() {

        }
        //parameter constructor
        public bankAccount( int accountNum){
            this.accountNum = accountNum;
            balance = 0;
        }

        // Getters method - No need for a setter for balance, this is done by withdraw and deposit
        public double getBalance () {
            return this.balance;
        }

        public int getAccountNum () {
            return this.accountNum;
        }

        //Abstract
        //Function to deposit funds into account
        //must be > 0

        public double deposit(double amount){
            return this.balance;
        }

        //Function to withdraw into acct
        // must be > 0  and amt withdraw be <= balance

        public double withdraw(double amount){
            return this.balance;
        }


}