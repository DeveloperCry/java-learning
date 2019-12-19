package learning.singleton;

/**
 * 静态内部类
 * 线程安全
 * 当加载外部类的时候不会加载内部类，这样也可以实现懒加载。
 * 其实和第一个有相似之处，都是由JVM来保证线程安全。
 */
public class Singleton07 {

    private Singleton07() {

    }

    private static class Singleton07Inner {
        private final static Singleton07 SINGLETON = new Singleton07();
    }

    public static Singleton07 getInstance() {//当调用该方法的时候才会加载Singleton07Inner
        return Singleton07Inner.SINGLETON;
    }
}
