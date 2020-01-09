package learning.thread.startathread;

public class ImplRunnableTest {
    private static void testImplRunnable() {
        Thread d1 = new Thread(new ImplRunnable("线程1"));
        Thread d2 = new Thread(new ImplRunnable("线程2"), "线程22");

        d1.start();
        d2.start();
        System.out.println("d1的线程名称：" + d1.getName());
        System.out.println("d2的线程名称：" + d2.getName());
        System.out.println("主线程名称：" + Thread.currentThread().getName());
    }

    /**
     * 这样不是启动一个线程,而是在调用run方法
     */
    private static void testInvokeRun() {
        System.out.println("这样不是启动一个线程");
        Thread d1 = new Thread(new ImplRunnable("线程1"));
        Thread d2 = new Thread(new ImplRunnable("线程2"), "线程22");

        d1.run();//不是启动一个线程，而是在调用run方法
        d2.run();
        System.out.println("d1的线程名称：" + d1.getName());
        System.out.println("d2的线程名称：" + d2.getName());
        System.out.println("主线程名称：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("这里是在测试启动一个线程，可以看出结果不是顺序输出的");
        testImplRunnable();

//        System.out.println("这里是在测试直接调用run方法，可以看出结果是顺序输出的，即先是线程1，再是线程2的结果");
//        testInvokeRun();
    }
}
