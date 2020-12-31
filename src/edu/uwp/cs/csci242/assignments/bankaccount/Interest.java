package edu.uwp.cs.csci242.assignments.bankaccount;
/**
 * Class Description of Interest
 * @author Donari Brandes
 * This is a class that encapsulates calculating interest for accounts with two methods
 * for calculating simple and compound interest.
 * @edu.uwp.cs.242.course CSCI 242 -Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs none
 */

public class Interest {

    /**
     * This method calculates simple interest with the account balance, interest rate, and time.
     * @param principle holds that balance of the account
     * @param interestRate holds the interest rate
     * @param time holds the time for simple interest calculation
     * @return returns the calculated simple interest value
     */
    public static float simple(float principle, float interestRate, int time){
        return principle * interestRate * time;
    }

    /**
     * This method calculates the compound interest with the account balance, interest rate,
     * number of times it is compounded, and the time.
     * @param principle holds the balance of the account
     * @param interestRate holds the interest rate
     * @param compounded holds the number of times compounded
     * @param time holds the time for compounded interest calculation
     * @return returns the calculated compound interest value
     */
    public static float compound(float principle, float interestRate, int compounded, int time){
        double sumRate = 1 + (interestRate / compounded);
        double exponent = compounded * time;
        float rateToExponent = (float) Math.pow(sumRate, exponent);
        float productRate = principle * rateToExponent;
        return productRate - principle;
    }

}
