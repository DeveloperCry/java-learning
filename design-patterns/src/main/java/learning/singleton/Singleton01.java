package learning.singleton;

/**
 * 饿汉式
 * 线程安全
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全(原因是一个class文件只load一次)
 * 简单实用，推荐使用！(一般这样用就可以了)
 * 唯一缺点：不管用到与否，类装载时就完成实例化(如果文件太大就惨了，这样就会占用内存资源)
 */
public class Singleton01 {
    private final static Singleton01 SINGLETON = new Singleton01();

    private Singleton01() {

    }

    public static Singleton01 getInstance() {
        return SINGLETON;
    }
}
