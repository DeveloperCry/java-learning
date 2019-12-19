package learning.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Singleton07Test {
    @Test
    public void testSingleton() {
        Singleton07 s01 = Singleton07.getInstance();
        Singleton07 s02 = Singleton07.getInstance();

        Assert.assertEquals(s01, s02);

        System.out.println(s01);
        System.out.println(s02);
        System.out.println(s01.hashCode());
        System.out.println(s02.hashCode());
    }

    @Test
    public void testSingleton_thread() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> System.out.println(Singleton07.getInstance().hashCode())).start();
        }
    }

    @Test
    public void testSingleton_juc() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            service.submit(() -> System.out.println(Singleton07.getInstance().hashCode()));
        }
        service.shutdown();
    }
}
