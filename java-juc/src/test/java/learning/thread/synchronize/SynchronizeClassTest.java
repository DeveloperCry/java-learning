package learning.thread.synchronize;

public class SynchronizeClassTest {
    public static void main(String[] args) {
        SynchronizeClass method = new SynchronizeClass();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                method.add();
            });
            thread.start();
        }
    }
}
