package learning.thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 这个类是为了同步和非同步方法同时调用
 *
 * 这个程序测试的锁是否可以重新进入
 *
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
 * 也就是说synchronized获得的锁是可重入的
 *
 * 这就是一个方法调用，第二个方法加不加synchronized都可以，当进入第二个方法的时候是可以访问，而不是等待的；
 * 如果不可以重入的话，在调用第二个方法的时候就会锁住，但是这里没有。说明就可以重入
 *
 * 同理，在继承的时候也可以重入，就是父类是同步的，继承的方法也是同步的
 *
 */
public class SynchronizeReentry {
    private int count = 0;
    public synchronized int synchronizedAdd() {//这里相当于synchronized(this)
        System.out.println(Thread.currentThread().getName() + " start");
        reentrySynchronizedAdd();
        for (int j = 0; j < 10; j++) {
//            try {
//                TimeUnit.MILLISECONDS.sleep(1);//让其他线程有进入的机会
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            count++;
            System.out.println(Thread.currentThread().getName() + "：" + j + ", 当前count：" + count);
        }
        System.out.println(Thread.currentThread().getName() + " end");
        return count;
    }

    public /*synchronized*/ int reentrySynchronizedAdd() {//这里是方法调用
        System.out.println("重入线程开始start");
        for (int j = 0; j < 10; j++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);//让其他线程有进入的机会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "：" + j + ", 当前count：" + count);
        }
        System.out.println("重入线程结束end");
        return count;
    }
}
