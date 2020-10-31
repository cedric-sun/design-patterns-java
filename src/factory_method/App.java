package factory_method;

import factory_method.framework.Factory;
import factory_method.framework.Product;
import factory_method.idcard.IDCardFactory;

// Even the responsibility of creating an object is given to the factory,
// the factory internally has to have some way to obtain an "fresh" object.
// 1. The most obvious one is to just use the "new" keyword directly in the factory superclass.
// 2. In factory method pattern, such an "fresh" object is returned from
//      an abstract method in the factory superclass that will be implemented
//      in concrete factory subclass.
//      (feels like template method pattern inside the factory class hierarchy)
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
