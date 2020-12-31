package edu.uwp.cs.csci242.assignments.bankaccount;

/**
 * Class Description of edu.uwp.cs.csci242.assignments.bankaccount.Checking
 * @author Donari Brandes
 * This is a subclass that extends Account and has two constructors and
 * 3 methods to adjust the balance of checking after interest is added.
 * @edu.uwp.cs.242.course CSCI 242 -Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs none
 */
public class Checking extends Account {
    /**
     * This constructor calls the superclass Account no-arg constructor.
     */
    public Checking(){
        super();
    }

    /**
     * This constructor calls the 3-arg constructor in the superclass Account.
     * @param customer variable for customer
     * @param name variable holds name of customer
     * @param balance variable holds balance of edu.uwp.cs.csci242.assignments.bankaccount.Checking account
     */
    public Checking(String customer, String name, float balance){
        super(customer, name, balance);

    }

    /**
     * This method applies interest calculated with getInterest() to
     * checking balance.
     * @param period variable holds amount of time for interest calculation
     * @return returns amount of interest applied
     */
    public float applyInterest(int period){
        float balance = getBalance();
        float interest = getInterest(period);
        float newBalance = interest + balance;
        super.deposit(interest);
        return newBalance;
    }

    /**
     * This method calls the interest class to calculate simple interest if balance
     * is over $700
     * @param period variable holds amount of time for interest calculation
     * @return returns amount of interest applied
     */
    public float getInterest(int period) throws IllegalArgumentException{
        float balance = super.getBalance();
        float interest = 0;
        try{
            if(balance > 700){
                interest = Interest.simple(balance, 0.02f, period);
            }
        }
        catch (Exception e){
            System.out.println("Balance must be above $700 to acquire interest.");
        }
        return interest;
    }

    /**
     * This method writesCheck for bills
     * @param bill amount on bill
     * @return returns bill amount
     */
    public float writeCheck(float bill){
        float newBalance = super.getBalance();
        super.withdraw(bill);
        return newBalance;
    }

    /**
     * This method prints a summary of the checking account balance and id number.
     * @return string containing checking account information
     */
    public String toString(){
        return "| Current balance of checking [" + getId() + "], 'Checking account' is: $" + String.format("%.2f", getBalance());
    }
}
