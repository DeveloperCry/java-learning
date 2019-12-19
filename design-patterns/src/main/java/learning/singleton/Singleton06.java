package learning.singleton;

/**
 * 懒汉式
 * 线程安全
 * 局部锁，双重检查，这样的话就会解决Singleton05中的问题，但是这里必须加上volatile，原因在于在高并发的情况下，
 * 由于第一个线程线程还没有初始化完，第二个线程发现第一个线程已经初始化了，就会直接使用，这个时候第二个线程就有可能拿到一个不可用的对象，
 * 就是只有地址，还没有将所有的内容加载完
 */
public class Singleton06 {
    private static volatile Singleton06 SINGLETON = null;

    private Singleton06() {

    }

    public static Singleton06 getInstance() {
        if (SINGLETON  == null) {
            synchronized (Singleton06.class) {//
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (SINGLETON == null) {
                    SINGLETON = new Singleton06();
                }
            }
        }
        return SINGLETON;
    }
}
