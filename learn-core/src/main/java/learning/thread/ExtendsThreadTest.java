package learning.thread;

public class ExtendsThreadTest {
    public static void main(String[] args) {
        ExtendsThread d1 = new ExtendsThread("线程1");
        ExtendsThread d2 = new ExtendsThread("线程2");

//        d1.run();//不是启动一个线程，而是在调用run方法
        d1.start();
        d2.start();

//        d1.interrupt();//这里用interrupt比stop好，因为stop不会释放资源 && 线程调用interrupt如果正在sleep就会抛出java.lang.InterruptedException: sleep interrupted异常。
    }
}
