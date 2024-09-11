// Proxy Pattern: Bank Application

// Subject Interface
interface BankAccount {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

// Real Subject, Actual Bank Account
class RealBankAccount implements BankAccount {
    private double balance;

    public RealBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// Proxy Class, Duplicate Subject
class BankAccountProxy implements BankAccount {
    private RealBankAccount realBankAccount;

    public BankAccountProxy(RealBankAccount realBankAccount) {
        this.realBankAccount = realBankAccount;
    }

    @Override
    public void deposit(double amount) {
        realBankAccount.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        realBankAccount.withdraw(amount);
    }

    @Override
    public double getBalance() {
        return realBankAccount.getBalance();
    }
}

// Client Code
public class ProxyPattern {
    public static void main(String[] args) {
        RealBankAccount realBankAccount = new RealBankAccount(1000);
        BankAccount proxy = new BankAccountProxy(realBankAccount);

        proxy.deposit(200);
        proxy.withdraw(150);
        System.out.println("Current Balance: " + proxy.getBalance());
    }
}

// The Proxy Pattern is used here to manage access to a bank account. The BankAccountProxy 
// acts as an intermediary between the user and the RealBankAccount, forwarding 
// requests for deposits, withdrawals, and balance checks. This setup ensures that 
// all user operations are mediated through the proxy, which controls interactions 
// with the actual bank account.