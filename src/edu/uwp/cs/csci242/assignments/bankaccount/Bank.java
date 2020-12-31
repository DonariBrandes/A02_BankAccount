package edu.uwp.cs.csci242.assignments.bankaccount;

/**
 * Class Description of Bank
 *
 * @author Donari Brandes
 * This is a class that contains the main() and a print balances method. It creates instances
 * of Account, Checking, Savings, and College savings and then manipulates the balances with life-like
 * transactions using methods created throughout the subclasses.
 * @edu.uwp.cs.242.course CSCI 242 -Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 1
 * @bugs none
 */
public class Bank {
    public static void main(String[] args) {
        System.out.println("Hello Changes");
        //create instances of each account for Jared Burgess
        Account account1 = new Account("1", "Jared Burgess", 13000);
        Checking checkingAct1 = new Checking("1", "Jared Burgess", 2000);
        CollegeSavings collSavings1 = new CollegeSavings("1", "Jared Burgess", 10000);
        Savings savings1 = new Savings("1", "Jared Burgess", 1000);

        //print original balance amounts
        printBalances(account1, checkingAct1, collSavings1, savings1);

        //print account balances after paycheck
        float paycheck = 6000f;
        float collSavingsDep = 1000f;

        //split the remaining amount in two for checking and savings account
        float checkAndSavAmnt = (paycheck - collSavingsDep) / 2;

        //print heading and deposit amounts into accounts, then print summary
        System.out.println("Got a paycheck: $" + paycheck + ". " + collSavingsDep + " in college savings, then half " +
                "in savings & half in checking.");
        collSavings1.deposit(collSavingsDep);
        checkingAct1.deposit(checkAndSavAmnt);
        savings1.deposit(checkAndSavAmnt);
        printBalances(account1, checkingAct1, collSavings1, savings1);

        //print heading, apply interest, and print balances after interest applied
        System.out.println("Time for interest!.");
        checkingAct1.applyInterest(1);
        collSavings1.applyInterest(1, 2);
        savings1.applyInterest(1, 2);
        printBalances(account1, checkingAct1, collSavings1, savings1);

        //declare bill values to pay bills, print heading and summary of bills
        float mortgage = 1575.50f;
        float gasAndElect = 90.75f;
        float water = 120.50f;
        float electronics = 155.25f;
        System.out.println("Write some bills...");
        System.out.println("> House mortgage, $" + String.format("%.2f", mortgage));
        System.out.println("> Gas and electric, $" + String.format("%.2f", gasAndElect));
        System.out.println("> Water, $" + String.format("%.2f", water));
        System.out.println("> TV/Internet/phone $" + String.format("%.2f", electronics));

        //call writeCheck methods to withdraw bills and print new balances
        checkingAct1.writeCheck(mortgage);
        checkingAct1.writeCheck(gasAndElect);
        checkingAct1.writeCheck(water);
        checkingAct1.writeCheck(electronics);
        printBalances(account1, checkingAct1, collSavings1, savings1);

        //declare expense values to write checks and print summary of normal expenses
        float groceries = 136.74f;
        float nightOut = 85.37f;
        float fixCar = 562.12f;
        System.out.println("Live life...");
        System.out.println("> Groceries, $" + String.format("%.2f", groceries));
        System.out.println("> Night out, $" + String.format("%.2f", nightOut));
        System.out.println("> Fix car, $" + String.format("%.2f", fixCar));

        //call writeCheck method to withdraw expenses and print new balances
        checkingAct1.writeCheck(groceries);
        checkingAct1.writeCheck(nightOut);
        checkingAct1.writeCheck(fixCar);
        printBalances(account1, checkingAct1, collSavings1, savings1);

        //create variable for amount needed for vacation and print heading
        float moneyForVaca = 6000f;
        System.out.println("Vacation, " + String.format("%.2f", moneyForVaca));

        //check if balance of savings is more than vacation expense
        //if not, then withdraw from collegeSavings at 10% fee
        boolean canGoVaca = savings1.isAmountAvailable(moneyForVaca);
        if (!canGoVaca) {
            float moneyNeeded = moneyForVaca - savings1.getBalance();
            float takeFromSav = moneyForVaca - moneyNeeded;
            collSavings1.withdraw(moneyNeeded);
            savings1.deposit(moneyNeeded);
            savings1.isAmountAvailable(moneyForVaca);
            savings1.withdraw(takeFromSav);
        }
        printBalances(account1, checkingAct1, collSavings1, savings1);

        //create variable for money needed for tuition, withdraw, and print new balances
        float tuition = 8000;
        System.out.println("Tuition, $" + String.format("%.2f", tuition));
        collSavings1.withdrawForCollege(tuition);
        printBalances(account1, checkingAct1, collSavings1, savings1);


    }

    /**
     * This method calls the toString methods of the Account, Checking, College Savings,
     * and Savings classes to print out a summary of the balances.
     *
     * @param account        object account for the instance created in main
     * @param checking       object checking for the instance created in main
     * @param collegeSavings object collegeSavings for the instance created in main
     * @param savings        object savings for the instance created in main
     */
    public static void printBalances(Account account, Checking checking, CollegeSavings collegeSavings, Savings savings) {
        System.out.println(account.toString());
        System.out.println(checking.toString());
        System.out.println(collegeSavings.toString());
        System.out.println(savings.toString());

    }

}
