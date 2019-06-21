package prototype;

import prototype.framework.Manager;
import prototype.framework.Product;

public class App {
    public static void main(String[] args) {
        Manager manager = new Manager();

        UnderlinePen upen = new UnderlinePen('~');
        MessageBox asterBox = new MessageBox('*');
        MessageBox slashBox = new MessageBox('/');

        manager.register("strong msg",upen);
        manager.register("warning box",asterBox);
        manager.register("slash box", slashBox);

        Product p1 = manager.create("strong msg");
        p1.use("Hello World");

        Product p2 = manager.create("warning box");
        p2.use("Hello World");

        Product p3 = manager.create("slash box");
        p3.use("Hello World");
    }
}
