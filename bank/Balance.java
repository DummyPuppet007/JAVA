package bank;

public class Balance {
    private int balance;

    public Balance(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal amount exceeds balance or is negative.");
        }
    }

    public int getBalance() {
        return balance;
    }
}
