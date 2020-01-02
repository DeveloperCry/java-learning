package learning.composite;

public class Leaf extends Product {
    private float price;

    public Leaf(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return this.price;
    }
}
