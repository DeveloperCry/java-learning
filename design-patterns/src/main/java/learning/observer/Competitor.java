package learning.observer;

public class Competitor implements Observer {
    @Override
    public void update(String name, String newProduct) {
        System.out.println(name + "又有新的产品发布了，新的产品是：" + newProduct + "，我们也要发布一个");
    }
}
