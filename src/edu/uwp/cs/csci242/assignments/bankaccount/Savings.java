package edu.uwp.cs.csci242.assignments.bankaccount;
/**
 * Class Description of Savings
 * @author Donari Brandes
 * This is a subclass that extends Account and has two constructors and
 * 2 methods to adjust the balance of checking after interest is added.
 * @edu.uwp.cs.242.course CSCI 242 -Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs none
 */
public class Savings extends Account{
    /**
     * No-arg constructor sets calls the super class constructor.
     */
    public Savings(){
        super();
    }

    /**
     * Constructor takes and sets customer, name, and balance to parameter values
     * @param customer holds value for id of customer
     * @param name holds name of customer
     * @param balance holds balance of account
     */
    public Savings(String customer, String name, float balance){
        super(customer, name, balance);
    }

    /**
     * This method applies interest calculated with getInterest() and adds it to
     * savings balance.
     * @param period variable holds amount of time for interest calculation
     * @param timesPerYear variable holds number of times compounded per year
     * @return returns amount of interest applied
     */
    public float applyInterest(int period, int timesPerYear){
        float balance = getBalance();
        float interest = getInterest(period, timesPerYear);
        float newBalance = interest + balance;
        super.deposit(interest);
        return newBalance;
    }
    /**
     * This method calls the interest class to calculate compound interest
     * @param period variable holds amount of time for interest calculation
     * @param timesPerYear variable holds number of times compounded per year
     * @return returns amount of interest applied
     */
    public float getInterest(int period, int timesPerYear){
        float balance = super.getBalance();
        return Interest.compound(balance, .0125f, timesPerYear, period);
    }

    /**
     * This method prints a summary of the savings account balance and id number.
     * @return string containing savings account information
     */
    public String toString(){
        System.out.println("| Current Balance of savings [" + getId() + "], 'Savings account' is: $" + String.format("%.2f", getBalance()));
        return "+-----------------------------";
    }
}
