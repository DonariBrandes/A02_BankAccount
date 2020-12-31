package edu.uwp.cs.csci242.assignments.bankaccount;
/**
 * Class Description of CollegeSavings
 * @author Donari Brandes
 * This is a subclass that extends Savings that has two constructors and
 * 2 methods to adjust the balance of CollegeSavings after withdraw is made.
 * @edu.uwp.cs.242.course CSCI 242 -Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs none
 */
public class CollegeSavings extends Savings {

    /**
     * This is a no-arg constructor that calls the superclass Savings
     */
    public CollegeSavings(){
        super();
    }

    /**
     * This is a 3-arg constructor that calls the superclass Savings
     * 3-arg constructor.
     * @param customer variable holds customer
     * @param name variable holds name of customer
     * @param balance variable holds the balance of College Savings Account
     */
    public CollegeSavings(String customer, String name, float balance){
        super(customer, name, balance);
    }

    /**
     * This method subtracts non-tuition withdraws plus 10% or calls
     * withdrawForCollege method for no 10% fee.
     * @param amount value to be subtracted from balance
     * @return returns new balance of CollegeSavings
     */
    public float withdraw(float amount){
        float tenPercent = amount * .1f;
        float withdrawAmnt = amount - tenPercent;
        super.withdraw(withdrawAmnt);
        return withdrawAmnt;
    }

    /**
     * This method subtracts amount from balance if it is for tuition.
     * @param amount value to be subtracted from balance
     * @return returns new balance of CollegeSavings
     */
    public float withdrawForCollege(float amount){
        float newBalance = getBalance() - amount;
        super.withdraw(amount);
        return newBalance;
    }

    /**
     * This method prints a summary of the college savings account balance and id number.
     * @return string containing college savings account information
     */
    public String toString(){
        return "| Current balance of college savings [" + getId() + "], 'College Savings' is: $" + String.format("%.2f", getBalance());
    }
}
