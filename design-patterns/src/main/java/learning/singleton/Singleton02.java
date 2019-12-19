package learning.singleton;

/**
 * 和Singleton一样
 */
public class Singleton02 {
    private final static Singleton02 SINGLETON;

    static {//load 的时候就会执行
        SINGLETON = new Singleton02();
    }

    private Singleton02() {

    }

    public static Singleton02 getInstance() {
        return SINGLETON;
    }
}
