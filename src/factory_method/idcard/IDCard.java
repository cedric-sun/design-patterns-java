package factory_method.idcard;

import factory_method.framework.Product;

public class IDCard extends Product {
    private String owner;

    public IDCard(String owner) {
        System.out.println(
                String.format("Making ID card of: %s",owner));
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public void use() {
        System.out.println(
                String.format("Using ID card of: %s",owner));
    }
}
