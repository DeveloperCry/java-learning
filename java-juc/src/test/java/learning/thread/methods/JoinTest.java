package learning.thread.methods;

/**
 *
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Join join = new Join();
        Thread thread = join.getThread1();
//        thread.join();  // 不能放在这里，因为线程还没有启动
        thread.start();
        thread.join();// 如果没有join，则会里面输出以下语句，然后在输出thread中的信息；如果有join，则以下语句最后输出。这里要理解，这里其实有两个线程在工作，一个是thread，还有一个就是main
        System.out.println(Thread.currentThread().getName() + ", 其状态是：" + Thread.currentThread().getState());

    }
}
