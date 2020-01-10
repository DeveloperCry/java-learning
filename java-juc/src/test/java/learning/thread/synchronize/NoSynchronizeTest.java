package learning.thread.synchronize;

public class NoSynchronizeTest {
    public static void main(String[] args) {
        NoSynchronize method = new NoSynchronize();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                method.add();
            }).start();
        }
    }
}
