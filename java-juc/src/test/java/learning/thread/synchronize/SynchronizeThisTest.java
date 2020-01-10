package learning.thread.synchronize;

public class SynchronizeThisTest {
    public static void main(String[] args) {
        SynchronizeThis method = new SynchronizeThis();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                method.add();
            });
            thread.start();
        }
    }
}
