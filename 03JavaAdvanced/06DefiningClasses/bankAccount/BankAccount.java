package bankAccount;

public class BankAccount {
    // Interest - лихва
    // Interest rate: double (Shared for all accounts. Default value: 0.02)
    private static double interestRate = 0.02;
    private double interest = interestRate;

    // Id: int (Starts from 1 and increments for every new account)
    private static int bankAccountCount = 1;
    private int id;

    private double balance;

    // Set the id of an account upon creation while incrementing the global account count
    public BankAccount() {
        this.id = bankAccountCount;
        bankAccountCount++;
        //this.interest = interestRate;
    }

    // Create a setter for the global interest rate.
    // Making the method static will let you access it through the class name


    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    // Implement deposit() and getInterest()
    public void deposit(double amount){
        this.balance += amount;
    }

    public double getInterest(int years){
        return BankAccount.interestRate * years * this.balance;
    }

    public int getId() {
        return id;
    }
}
