//TEST CODE AND MAIN METHOD GO IN HERE
public class TestBankAccount{

    public static void main(String[] args) {
    BankAccount account1 = new BankAccount();
    BankAccount account2 = new BankAccount();
    BankAccount account3 = new BankAccount();

    //TESTING THE DEPOSIT FEATURE FOR CHECKING 
    account1.depositChecking(500.0);
    System.out.println(account1.getCheckingBalance());

     //TESTING THE DEPOSIT FEATURE FOR SAVINGS 
    account1.depositSavings(600.0);

    //TESTING TO SEE IF INSUFFICIENT FUNDS
    account2.withdrawChecking(800.0);

    //TESTING TO SEE TOTAL AMOUNT OF MONEY IN ALL ACCOUNTS
    BankAccount.seeTotalMoney();
    
    }
}