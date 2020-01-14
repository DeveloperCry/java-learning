package learning.thread.methods;

/**
 * 唤醒等待该锁的所有的线程
 */
public class NotifyAll {
    private int count = 0;
    private final Object obj = new Object();

    public int add() throws InterruptedException {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
                if (i == 5) {
                    System.out.println(Thread.currentThread().getName() + " 等待开始");
                    obj.wait();
                    System.out.println(Thread.currentThread().getName() + " 等待结束");
                }
            }
        }
        return count;
    }

    public int add2() throws InterruptedException {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
            }
            obj.notifyAll();//如果这里没有释放的话，线程1就会一直等待
        }

        return count;
    }
}
