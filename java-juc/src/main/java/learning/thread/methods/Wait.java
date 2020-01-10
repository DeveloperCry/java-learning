package learning.thread.methods;

/**
 * wait就是将线程设置为等待状态并让出锁和CPU，知道得到通知或者是等待的时间结束了再运行
 *
 * 进入wait状态的线程被唤醒后，会重新去竞争锁，如果获取到锁，会接着上次执行的地方接着执行
 *
 * 这是一个简单的等待
 *
 * 调用wait\notify\notifyall方法时，需要与锁或者synchronized搭配使用，不然会报错java.lang.IllegalMonitorStateException，
 * 因为任何时刻，对象的控制权只能一个线程持有，因此调用wait等方法的时候，必须确保对其的控制权。
 *
 * 如果一个线程调用了某个对象的wait方法，那么该线程进入到该对象的等待池中(并且已经将锁释放)，
 * 如果未来的某一时刻，另外一个线程调用了相同对象的notify方法或者notifyAll方法，
 * 那么该等待池中的线程就会被唤起，然后进入到对象的锁池里面去获得该对象的锁，
 * 如果获得锁成功后，那么该线程就会沿着wait方法之后的路径继续执行。注意是沿着wait方法之后
 *
 */
public class Wait {

    private int count = 0;
    private final Object obj = new Object();

    public int add() throws InterruptedException {
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + "开始");
            obj.wait();
            System.out.println(Thread.currentThread().getName() + "wait");
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
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
            obj.notify();//如果这里没有释放的话，线程1就会一直等待
        }

        return count;
    }
}
