package learning.thread.concurrent.locks.reentrantlock;

public class ReentrantLock1Test {

    public static void main(String[] args) {
        ReentrantLock1 lock1 = new ReentrantLock1();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> lock1.add()).start();
        }
    }
}
