package learning.thread.methods;

/**
 * wait就是将线程设置为等待状态并让出锁和CPU，知道得到通知或者是等待的时间结束了再运行
 *
 * 这是一个当等待到时间的时候自动释放
 *
 * 如果wait中的参数是0的话，就等同于wait()，会一直等下去直到notify
 */
public class WaitTimeout {

    private int count = 0;
    private final Object obj = new Object();

    public int add() throws InterruptedException {
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + "开始");
            obj.wait(4000);//这里的意思就是最长等待4s
            System.out.println(Thread.currentThread().getName() + "wait");
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
            }
        }
        return count;
    }

    public int add2() {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
            }
        }

        return count;
    }
}
