package learning.singleton;

/**
 * 懒汉式
 * 线程不安全
 */
public class Singleton03 {
    private static Singleton03 SINGLETON = null;

    private Singleton03() {

    }

    public static Singleton03 getInstance() {
        if (SINGLETON  == null) {
            SINGLETON = new Singleton03();
        }
        return SINGLETON;
    }
}
