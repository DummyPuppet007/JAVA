import bank.Balance;

public class TestBalance {
    public static void main(String[] args) {
        Balance b = new Balance(1000); 
        b.deposit(500);                
        b.withdraw(300); 
        int curBalance = b.getBalance();
        System.out.println("Current Balance : " + curBalance);                     
    }
}

//Compile
// javac bank/Balance.java
// javac -cp . TestBalance.java

//Run
//java TestBalance