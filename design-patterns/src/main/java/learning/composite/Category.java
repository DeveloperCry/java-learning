package learning.composite;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class Category extends Product {
    private List<Product> children = new ArrayList<>();

    public void add(Product product) {
        this.children.add(product);
    }

    public void remove(Product product) {
        this.children.remove(product);
    }

    public List<Product> getChildren() {
        return this.children;
    }

    @Override
    public float getPrice() {
        return this.getAllPrices(this.children);
    }

    private float getAllPrices(List<Product> products) {
        float price = 0f;
        for (Product product : products){
            if (product instanceof Leaf) {
                price += product.getPrice();
            } else if (CollectionUtils.isNotEmpty(((Category)product).getChildren())) {
                price += this.getAllPrices(((Category)product).getChildren());
            }
        }
        return price;
    }
}
