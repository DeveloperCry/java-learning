package learning.thread.synchronize;

public class SynchronizeStaticClassTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SynchronizeStaticClass.add();
            }).start();
        }
    }
}
