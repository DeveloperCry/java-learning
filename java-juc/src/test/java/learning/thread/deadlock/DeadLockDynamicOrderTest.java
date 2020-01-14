package learning.thread.deadlock;

public class DeadLockDynamicOrderTest {
    public static void main(String[] args) {
        Object obj = new Object();
        Object lock = new Object();

        DeadLockDynamicOrder deadLock = new DeadLockDynamicOrder();
        //这里注意两个被锁住对象的位置
        new Thread(() -> deadLock.add(obj, lock), "拥有资源不放线程").start();

        new Thread(() -> deadLock.add(lock, obj), "请求资源线程").start();
    }
}
