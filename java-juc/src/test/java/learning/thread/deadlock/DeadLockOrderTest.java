package learning.thread.deadlock;

public class DeadLockOrderTest {
    public static void main(String[] args) {
        DeadLockOrder wait = new DeadLockOrder();
        new Thread(() -> wait.add(), "拥有资源不放线程").start();

        new Thread(() -> wait.add2(), "请求资源线程").start();
    }
}
