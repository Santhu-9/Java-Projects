import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class BankAccount {
    private int accountNo;
    private String name;
    double balance;

    static int time = 1; // 1 year

    public BankAccount() {
    }

    // ArrayList of Bank Accounts
    static ArrayList<BankAccount> Accounts = new ArrayList<>();

    // Method to return no of accounts opened
    public int noOfAccounts() {
        return Accounts.size();
    }

    // Method to check if entered account number by user is existed in the ArrayList
    public boolean foundUser(int accountNo) {
        for (BankAccount account : Accounts) {
            if (account.accountNo == accountNo) return true;
        }
        return false;
    }

    // Method to deposit the amount
    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) System.out.println("Insufficient funds");
        else balance -= amount;
    }

    // Method to generate random number for account number
    public int generateAccNo() {
        return ThreadLocalRandom.current().nextInt(100000, 1000000);
    }

    // Constructor to set values when account is made
    public BankAccount(String name,double balance) {
        this.accountNo = generateAccNo();
        this.name = name;
        this.balance = balance;
    }

    //Method to check Balance with account number
    public void accountDetails(int accountNo) {
        if (foundUser(accountNo)) {
            System.out.println("Account No: " + accountNo + " Name: " + name + " Balance: " + balance + " /- ");
        } else System.out.println("Invalid account number!!");
    }

    // Method to view account number
    public int viewAccountNo() {
        return accountNo;
    }

    // Method to add account to the ArrayList
    public void addAccount(BankAccount account){
        Accounts.add(account);
    }

    public static BankAccount getUser(int accountNo) {
        for (BankAccount userAccount : Accounts) {
            if (userAccount.accountNo == accountNo) return userAccount;
        }
        return null;
    }

    public void calculateInterest() {}
}

    class SavingsAccount extends BankAccount {

        public SavingsAccount(String fullName, double initialBalance) {
            super(fullName, initialBalance);
        }

        public void calculateInterest() {
            System.out.println("Interest for 1 year: " + (balance * 4 * time) / 100);
        }
    }

    class CurrentAccount extends BankAccount {

        public CurrentAccount(String fullName, double initialBalance) {
            super(fullName, initialBalance);
        }

        public void calculateInterest() {
            System.out.println("Interest for 1 year: " + (balance * 1 * time) / 100);
        }
    }

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1.Create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Check Balance");
            System.out.println("5.Calculate Interest");
            System.out.println("6.Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1) {
                System.out.println("1.Savings Account");
                System.out.println("2.Current Account");
                int choice2 = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter Full Name: ");
                String fullName = sc.nextLine();

                System.out.println("Enter initial Balance: ");
                double initialBalance = sc.nextDouble();
                sc.nextLine();

                BankAccount account = null;

                if (choice2 == 1){
                    account = new SavingsAccount(fullName, initialBalance);
                    account.addAccount(account);
                    System.out.println("Your Savings Account Created Successfully!");
                    System.out.println("You acc no is " + account.viewAccountNo());
                }

                else if (choice2 == 2){
                    account = new CurrentAccount(fullName, initialBalance);
                    account.addAccount(account);
                    System.out.println("Your Savings Account Created Successfully!");
                    System.out.println("You acc no is " + account.viewAccountNo());
                }

                else {
                    System.out.println("Invalid choice!");
                    continue;
                }
            }

            else if(choice == 2) {
                System.out.println("Enter your Account number: ");
                int accountNo = sc.nextInt();
                System.out.println("Enter Amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                BankAccount thisUser = new BankAccount().getUser(accountNo);
                if(thisUser == null) System.out.println("Invalid Account");
                else thisUser.deposit(amount);
            }
            else if(choice == 3) {
                System.out.println("Enter your Account Number: ");
                int accountNo = sc.nextInt();
                System.out.println("Enter Amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();
                BankAccount thisUser = new BankAccount().getUser(accountNo);
                if(thisUser == null) System.out.println("Invalid Account");
                else thisUser.withdraw(amount);
            }
            else if (choice == 4) {
                System.out.println("Enter your Account number: ");
                int accountNo = sc.nextInt();
                sc.nextLine();

                BankAccount thisUser = new BankAccount().getUser(accountNo);
                if(thisUser == null) System.out.println("Invalid Account");
                else thisUser.accountDetails(accountNo);
            }
            else if (choice == 5) {
                System.out.println("Enter your Account Number: ");
                int accountNo = sc.nextInt();
                sc.nextLine();
                if(BankAccount.getUser(accountNo) == null) System.out.println("Invalid Account");
                else BankAccount.getUser(accountNo).calculateInterest();
            }
            else System.exit(0);
        }
    }
}
