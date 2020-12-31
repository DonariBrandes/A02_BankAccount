package edu.uwp.cs.csci242.assignments.bankaccount;
import java.util.Random;
/**
 * Class Description of Account
 * @author Donari Brandes
 * This is a super class that has two constructors and 13 methods
 * to retrieve the account holder's information.
 * @edu.uwp.cs.242.course CSCI 242 -Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs none
 */
public class Account {
    /**
     * Declare class level variables
     */
    private float balance;
    private String customer;
    private String id;
    private String name;

    /**
     * No-arg constructor sets default values to variables
     */
    public Account() {
        balance = 0;
        customer = "";
        id = "";
        name = "";
    }

    /**
     * Constructor takes and sets customer, name, and balance to parameter values
     * @param customer holds value for id of customer
     * @param name holds name of customer
     * @param balance holds balance of account
     */
    public Account(String customer, String name, float balance) {
        this.customer = makeId(10);
        this.name = name;
        this.balance = balance;
    }

    /**
     * This method adds amount taken to current balance and returns new balance.
     * @param amount This is the value to be added to the current balance.
     * @return Returns adjusted balance after deposit
     * @throws IllegalArgumentException Throws exception is amount is less than 1 dollar.
     */
    public float deposit(float amount) throws IllegalArgumentException{
        float currentBalance = getBalance();
        float newBalance = 0;
        try {
            if(amount > 1.00){
                newBalance = currentBalance + amount;
            }
        }
        catch(Exception e){
            System.out.println("Cannot accept deposit less than $1.00");
        }
        this.balance = newBalance;
        return newBalance;
    }

    /**
     * This method retrieves the current balance.
     * @return returns current balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * This method retrieves customer
     * @return returns customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * This method retrieves customer id
     * @return returns customer id
     */
    public String getId() {
        return id;
    }

    /**
     * This method retrieves customer name.
     * @return returns customer name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns true if variable amount is more than current balance.
     * @param amount number used to check if enough money in current balance
     * @return returns true if amount is more than balance and false if amount is less
     * than balance
     */
    public boolean isAmountAvailable(float amount){
        float currentBalance = getBalance();
        boolean enoughInAccount = true;
        try{
            if (amount > currentBalance){
                enoughInAccount = false;
                throw new IllegalArgumentException();
            }
        }
        catch(Exception e){
            System.out.println("> Funds not available...Must transfer...");
            System.out.println("> Not enough in checking+savings...Take from college fund at penalty...");
        }
        if(enoughInAccount){
            System.out.println("> Funds Available...going on vacation!");
        }
        return enoughInAccount;
    }

    /**
     * This method creates a random id with numbers 0-9.
     * @param size number of digits in id
     * @return returns random id number as a String
     */
    public String makeId (int size){
        Random rand = new Random();
        StringBuilder str = new StringBuilder(size);
        int randomInt;
        for(int i = 0; i < size; i++){
            randomInt = rand.nextInt(10);
            str.append(randomInt);
        }
        id = str.toString();
        return id;
    }

    /**
     * This method sets customer value
     * @param customer customer variable
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    /**
     * This method sets the customer's name.
     * @param name variable to hold name of customer
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * This method prints summary heading containing the name of the customer
     * @return string containing name of customer
     */
    public String toString(){
        return "+-- Customer: " + getName() + " ---";
    }

    /**
     * This method subtracts an amount from balance.
     * @param amount value to be subtracted from balance
     * @return returns new balance after withdraw
     */
    public float withdraw(float amount){
        float currentBalance = getBalance();
        float newBalance = 0;
        try {
            if(amount > 1.00){
                newBalance = currentBalance - amount;
            }
        }
        catch(Exception e){
            System.out.println("Cannot withdraw less than $1.00");
        }
        this.balance = newBalance;
        return newBalance;
    }
}
