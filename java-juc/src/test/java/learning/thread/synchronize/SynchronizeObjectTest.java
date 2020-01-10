package learning.thread.synchronize;

public class SynchronizeObjectTest {
    public static void main(String[] args) {
        SynchronizeObject method = new SynchronizeObject();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                method.add();
            }).start();
        }
    }
}
