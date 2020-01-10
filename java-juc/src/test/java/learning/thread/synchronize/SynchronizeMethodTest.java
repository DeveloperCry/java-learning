package learning.thread.synchronize;

public class SynchronizeMethodTest {
    public static void main(String[] args) {
        SynchronizeMethod method = new SynchronizeMethod();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                method.add();
            }).start();
        }
    }
}
