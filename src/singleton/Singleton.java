package singleton;

public class Singleton {
    static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("A instance of Singleton is generated.");
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
