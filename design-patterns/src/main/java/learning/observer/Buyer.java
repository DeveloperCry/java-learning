package learning.observer;

public class Buyer implements Observer{
    @Override
    public void update(String name, String newProduct) {
        System.out.println(name + "有新的产品发布了，产品是：" + newProduct + "，快去围观");
    }
}
