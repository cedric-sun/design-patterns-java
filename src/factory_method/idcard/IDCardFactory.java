package factory_method.idcard;

import factory_method.framework.Factory;
import factory_method.framework.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List<String> owners = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        if (product instanceof IDCard) {
            owners.add(((IDCard) product).getOwner());
        }
    }

    public List<String> getOnwers() {
        return owners;
    }
}
