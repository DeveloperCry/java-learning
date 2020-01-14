package learning.thread.methods;

/**
 * 唤醒一个线程，如果有多个，也只随机唤醒一个
 *
 * 唤醒正在此对象监视器上等待的单个线程。如果有任何线程正在等待这个对象，则选择其中一个线程被唤醒。这个选择是任意的，由实现来决定。
 * 线程通过调用一个等待方法来等待对象的监视器。
 * 被唤醒的线程将无法继续，直到当前线程释放该对象上的锁。被唤醒的线程将以通常的方式与任何其他线程竞争，这些线程可能正在积极地对这个对象进行同步;
 * 例如，在成为下一个锁定该对象的线程时，被唤醒的线程没有任何可靠的特权或缺点。
 *
 * 此方法应仅由此对象监视器的所有者所在的线程调用。线程通过以下三种方式之一成为对象监视器的所有者:
 *   通过执行该对象的同步实例方法。
 *   通过执行对对象进行同步的同步语句的主体。
 *   对于Class类型的对象，通过执行该类的同步静态方法。
 * 一次只有一个线程可以拥有一个对象的监视器。
 */
public class Notify {
    private int count = 0;
    private final Object obj = new Object();

    public int add() throws InterruptedException {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
                if (i == 5) {
                    System.out.println(Thread.currentThread().getName() + "等待开始");
                    obj.wait();
                    System.out.println(Thread.currentThread().getName() + "等待结束");
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
            obj.notify();//如果这里没有释放的话，线程1就会一直等待
        }

        return count;
    }
}
