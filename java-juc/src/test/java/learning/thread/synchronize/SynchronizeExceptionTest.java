package learning.thread.synchronize;

public class SynchronizeExceptionTest {
    public static void main(String[] args) {
        SynchronizeException method = new SynchronizeException();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> method.add()).start();
        }
    }
}
