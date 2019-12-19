package learning.singleton;

/**
 * 懒汉式
 * 线程不安全
 * 局部锁，存在的问题在于如果加载的类比较大，所以耗时比较多，这样，当第一个线程执行完if的时候发现SINGLETON为空，并且没有加锁，
 * 就会执行synchronized中的内容，当第二个线程执行的时候，发现SINGLETON为空并且有线程已经在执行了，所以就会挂起；
 * 当第一线程执行完之后，第二个线程开始执行，由于已经执行过if了，所以这次就直接进行初始化实例，这样就导致了有两个不同的实例
 */
public class Singleton05 {
    private static Singleton05 SINGLETON = null;

    private Singleton05() {

    }

    public static Singleton05 getInstance() {
        if (SINGLETON  == null) {
            synchronized (Singleton05.class) {//
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SINGLETON = new Singleton05();
            }
        }
        return SINGLETON;
    }
}
