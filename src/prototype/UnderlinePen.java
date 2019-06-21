package prototype;

import prototype.framework.Product;

public class UnderlinePen implements Product {
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        sb.append(' ');
        for (int i = 0; i < len; i++) sb.append(ulchar);
        sb.append(' ');

        System.out.println(String.format("\"%s\"",s));
        System.out.println(sb);
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
