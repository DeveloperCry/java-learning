package learning.thread.methods;

import java.util.concurrent.TimeUnit;

/**
 * 让程序沉睡指定的时间，当时间结束的时候自动唤醒
 */
public class Sleep {
    public void sleepMethod() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "：" + i + ", 其状态是：" + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
