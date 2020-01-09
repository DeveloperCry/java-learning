package learning.thread.startathread;

import java.util.concurrent.TimeUnit;

/**
 *  如果一个接口(interface)只有一个方法，那么可以直接用lambda表达式
 *
 *  这里就是Runnable接口中只有一个方法
 */
public class LambdaThreadTest {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("正在执行.....");
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
