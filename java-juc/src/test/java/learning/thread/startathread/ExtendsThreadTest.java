package learning.thread.startathread;

/**
 * 注意，这里还不能用JUnit来测试线程，因为在Test中不能启动start，
 * 这其中有一些解决方案，但是这里为了测试thread而保持代码的纯洁性，所以就直接用main函数了
 */
public class ExtendsThreadTest {
    private static void testExtends() {
        ExtendsThread d1 = new ExtendsThread("线程1");
        ExtendsThread d2 = new ExtendsThread("线程2");

        d1.start();
        d2.start();
        System.out.println("d1的线程名称：" + d1.getName());
        System.out.println("d2的线程名称：" + d2.getName());
        System.out.println("主线程名称：" + Thread.currentThread().getName());
    }

    /**
     * 这样不是启动一个线程，而是在调用run方法
     */
    private static void testInvokeRun() {
        ExtendsThread d1 = new ExtendsThread("线程1");
        ExtendsThread d2 = new ExtendsThread("线程2");

        d1.run();//不是启动一个线程，而是在调用run方法
        d2.run();
        System.out.println("d1的线程名称：" + d1.getName());
        System.out.println("d2的线程名称：" + d2.getName());
        System.out.println("主线程名称：" + Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("这里是在测试启动一个线程，可以看出结果不是顺序输出的");
//        testExtends();

        System.out.println("这里是在测试直接调用run方法，可以看出结果是顺序输出的，即先是线程1，再是线程2的结果");
        testInvokeRun();
    }
}
