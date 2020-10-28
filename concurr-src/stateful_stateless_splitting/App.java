package stateful_stateless_splitting;

class Account {
    public static final double MIN_BALANCE = 0;
    private String name, address;
    private double balance;

    // example 1: only lock the "stateful" part
    double computeFeeAndDeduct(double param) {
        double fee = computeFee(param);
        synchronized (this) {
            balance -= fee;
        }
        return fee;
    }

    // heavy computation but "stateless" function
    double computeFee(double param) {
        // omit some heavy operation ...
        return 1.23;
    }

    // example 2: get a local copy of "state" and work on that copy.
    // calculate a function of this.balance.
    // instead of `synchronize`-ing the whole method ...
    double getProjectedBalance(double rate) {
        double b;
        synchronized (this) {
            b = balance;
        }
        // do the stateless heavy computation
        return computeProjectedBalance(b, rate);
    }

    double computeProjectedBalance(double balance, double rate) {
        // omit some heavy operation ...
        return balance * rate;
    }
}

public class App {
    public static void main(String[] args) {

    }
}
