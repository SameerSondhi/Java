//BANK ACCOUNT CLASS
public class BankAccount{
private double checkingBalance;
private double savingsBalance;

private static int counter = 0;

private static double amountOfMoneyEveryAccount = 0;

private static double amount = 0;

//CONSTRUCTOR
public BankAccount(){
    checkingBalance = 0;
    savingsBalance = 0;
    counter++;
}

//METHODS GO HERE

//GETTER METHOD FOR CHECKING ACCOUNTS BALANCE
public double getCheckingBalance(){
    return this.checkingBalance;
}

//GETTER METHOD FOR CHECKING ACCOUNTS BALANCE
public double getSavingsBalance(){
    return this.savingsBalance;
}

//AMOUNT DEPOSITED IN CHECKING 
public void depositChecking(double amount){
    if(amount>0){
        checkingBalance+=amount;
        amountOfMoneyEveryAccount+=amount;
    }
}

//AMOUNT DEPOSITED IN SAVINGS 
public void depositSavings(double amount){
    if(amount>0){
        savingsBalance+=amount;
        amountOfMoneyEveryAccount+=amount;
    }
}

//AMOUNT WITHDRAWN FROM CHECKING
public void withdrawChecking(double amount){
    if(checkingBalance<amount){
        System.out.println("Insufficient funds");
    }
    if(checkingBalance>amount){
        checkingBalance-=amount;
        amountOfMoneyEveryAccount-=amount;
    }
}

//AMOUNT WITHDRAWN FROM SAVINGS
public void withdrawSavings(double amount){
    if(savingsBalance<amount){
        System.out.println("Insufficient funds");
    }
    if(savingsBalance>amount){
        savingsBalance-=amount;
        amountOfMoneyEveryAccount-=amount;
    }
}

//TOTAL AMOUNT IN ALL ACCOUNTS
public static void seeTotalMoney(){
    double total = amountOfMoneyEveryAccount;
    System.out.println("Total amount in both accounts is: " + total);
}

//COUNT THE NUMBER OF ACCOUNTS
public static int numberOfAccounts(){
    return counter;
}

}