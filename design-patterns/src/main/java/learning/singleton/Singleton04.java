package learning.singleton;

/**
 * 懒汉式
 * 线程安全
 * 在方法上加了一个synchronized, 当时这样就会有一个问题，每次访问的时候都会加锁，导致效率慢
 */
public class Singleton04 {
    private static Singleton04 SINGLETON = null;

    private Singleton04() {

    }

    public static synchronized Singleton04 getInstance() {
        if (SINGLETON  == null) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SINGLETON = new Singleton04();
        }
        return SINGLETON;
    }
}
