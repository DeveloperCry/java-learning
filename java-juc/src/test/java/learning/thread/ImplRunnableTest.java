package learning.thread;

public class ImplRunnableTest {
    public static void main(String[] args) {
        Thread d1 = new Thread(new ImplRunnable("线程1"));
        Thread d2 = new Thread(new ImplRunnable("线程2"), "线程22");

//        d1.run();//不是启动一个线程，而是在调用run方法
        d1.start();
        d2.start();
        System.out.println(d2.getName());
    }
}
