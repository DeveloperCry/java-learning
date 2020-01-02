package learning.observer;

public class TaoBao extends Publisher{
    public void publish() {
        System.out.println("这是淘宝新品发布会");
        super.notifyObservers("淘宝", "新手机");
    }
}
