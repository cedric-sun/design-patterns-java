package singleton;

public class App {
    public static void main(String[] args) {
        System.out.println("????");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        // static initialization is done when
        // the first time Singleton.getInstance() is invoked
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if (obj2 == obj1) {
            System.out.println("The same instance!");
        }
    }
}
