package locksplitting;

class Person {
    private String name, address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public synchronized void updateNameAddress(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

public class AccountGood {
    final Person p;
    double balance;

    public AccountGood(Person p, double balance) {
        this.p = p;
        this.balance = balance;
    }

    // now the method itself doesn't need to be synchronized
    public void updateNameAddress(String name, String address) {
        // delegate to synchronized Person method that use a different lock
        p.updateNameAddress(name, address);
    }

    // updateBalance() contends only with itself now.
    public synchronized void updateBalance(double balance) {
        this.balance = balance;
    }
}
