package factory_method;

import factory_method.framework.Factory;
import factory_method.framework.Product;
import factory_method.idcard.IDCardFactory;

public class App {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("ming");
        Product card2 = factory.create("hong");
        Product card3 = factory.create("gang");

        card1.use();
        card2.use();
        card3.use();
    }
}
