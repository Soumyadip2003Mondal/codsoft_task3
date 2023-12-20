import java.util.Scanner;
class BankAccount 
{
    private double balance;
    public BankAccount(double initialBalance) 
    {
        balance = initialBalance;
    }
    public double getBalance() 
    {
        return balance;
    }
    public void deposit(double amount) 
    {
        balance += amount;
    }
    public int withdraw(double amount) 
    {
        if (amount <= balance)
        {
            balance -= amount;
            return 1;
        }
        return 0;
    }
}
class ATM 
{
    private BankAccount account;
    public ATM(BankAccount bankAccount) 
    {
        account = bankAccount;
    }
    public void displayMenu() 
    {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void run() 
    {
        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            displayMenu();
            System.out.print("Select an option: ");
            int ch = scanner.nextInt();
            switch (ch) 
            {
                case 1:
                System.out.println("Your balance: Rs. " + account.getBalance());
                 break;
                case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful. Your balance: Rs. " + account.getBalance());
                break;
                case 3:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (account.withdraw(withdrawAmount)==1) 
                {
                    System.out.println("Withdrawal successful. Your balance: Rs. " + account.getBalance());
                } 
                else 
                {
                    System.out.println("Insufficient balance.");
                }
                break;
                case 4:
                System.out.println("Thank you for using the ATM!");
                scanner.close();
                return;
                default:
                System.out.println("Invalid option. Please reselect.");
            }
        }
    }
}
public class ATM_interface 
{
    public static void main(String[] args) 
    {
        BankAccount Account = new BankAccount(10000); // Initial balance
        ATM atm = new ATM(Account);
        atm.run();
    }
}