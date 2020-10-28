package locksplitting;

// An example of bad design:
// those two methods works on different fields, but will contend for the same lock
public class AccountBad {
    private String name, address;
    private double balance;

    synchronized void updateNameAddress(String newName, String newAddress) {
        this.name = newName;
        this.address = newAddress;
    }

    synchronized void updateBalance(double newBalance) {
        this.balance = newBalance;
    }
}
