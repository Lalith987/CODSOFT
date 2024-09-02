import java.util.Scanner;
class BankAccount 
{
    private double balance;

    public BankAccount(double bankBalance)
     {
        if (bankBalance >= 20)
         {
            this.balance = bankBalance;
        } 
        else 
        {
            System.out.println("The Bank balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }

    public void deposit(double amount)
     {
        if (amount > 10) 
        {
            balance += amount;
            System.out.println("Successfully deposited Rs" + amount);
        }
         else
         {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) 
    {
        if (amount > 20) 
        {
            if (amount <= balance)
             {
                balance -= amount;
                System.out.println("Successfully withdrew Rs" + amount);
            }
             else
              {
                System.out.println("Insufficient balance. Cannot withdraw Rs" + amount);
            }
        }
         else
         {
            System.out.println("Withdrawal amount must be positive and cannot be zero.");
        }
    }

    public double getBalance() 
    {
        return balance;
    }
}

class ATM
 {
    private BankAccount account;

    public ATM(BankAccount account)
     {
        this.account = account;
    }

    public void showMenu() 
    {
        Scanner scanner = new Scanner(System.in);
        int option;

        do
         {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. BankBalance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please select an option from 1 to 4: ");
            option = scanner.nextInt();

            switch (option) 
            {
                case 1:
                    System.out.println("Current Balance: Rs"+account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: Rs");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: Rs");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. comeagain");
                    break;
                default:
                    System.out.println("Invalid option. Please enter a valid option from 1 to 4.");
            }
        } 
        while (option != 4);

        scanner.close();
    }
}

public class ATMInterface
 {
    public static void main(String[] args) 
    {
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
