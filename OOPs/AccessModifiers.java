// Access Modifiers & Encapsulation in Java
// 1. private: Accessible only within the same class.
// 2. default (no modifier): Accessible only within the same package.
// 3. protected: Accessible within the same package, and outside package through inheritance (subclasses).
// 4. public: Accessible from anywhere.
// Getters & Setters are used to access and update private data, enforcing encapsulation.

class BankAccount {
    public String ownerName;       // Public: anyone can access
    protected String branchCode;    // Protected: package and subclasses
    String accountType;            // Default (no modifier): package-private
    private double balance;        // Private: only accessible within this class

    // Constructor
    public BankAccount(String ownerName, String branchCode, String accountType, double initialBalance) {
        this.ownerName = ownerName;
        this.branchCode = branchCode;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    // Getter for balance (to read private data)
    public double getBalance() {
        return this.balance;
    }

    // Setter for balance (to update private data with validation)
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Setter for withdrawing (with validation)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("Ayush", "SBIN0012", "Savings", 5000.0);

        // Accessing public, protected, and default members directly
        System.out.println("Owner: " + myAccount.ownerName);
        System.out.println("Branch Code: " + myAccount.branchCode);
        System.out.println("Account Type: " + myAccount.accountType);

        // System.out.println(myAccount.balance); // ERROR! Private variable cannot be accessed directly

        // Accessing private member through Getter
        System.out.println("Initial Balance: $" + myAccount.getBalance());

        // Modifying private member through Setter methods (Safe encapsulation)
        myAccount.deposit(1500.0);
        System.out.println("Balance after deposit: $" + myAccount.getBalance());

        myAccount.withdraw(2000.0);
        System.out.println("Balance after withdrawal: $" + myAccount.getBalance());

        myAccount.withdraw(10000.0); // Fails due to validation logic in setter
    }
}
