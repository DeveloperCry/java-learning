package learning.thread.synchronize;

public class SynchronizeRunTest {
    public static void main(String[] args) {
        SynchronizeRun run = new SynchronizeRun(); // 当对象写在这里的时候，当前只有一个对象，所以上锁的时候也是该对象，这个时候结果是顺序加到100
        for (int i = 0; i < 10; i++) {
//            SynchronizeRun run = new SynchronizeRun(); // 这个时候是多个对象，当前锁的是不同的对象，这个时候结果不是顺序执行的，同时每个线程最后都是只加到10
            Thread thread = new Thread(run);
            thread.start();
        }
    }
}
