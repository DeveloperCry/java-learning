package learning.thread.synchronize;

public class SynchronizeStaticMethodTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                SynchronizeStaticMethod.add();
            }).start();
        }
    }
}
