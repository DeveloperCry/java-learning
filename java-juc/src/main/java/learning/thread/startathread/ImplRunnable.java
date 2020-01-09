package learning.thread.startathread;

import java.util.concurrent.TimeUnit;

/**
 * 这是一个实现Runnable的线程
 */
public class ImplRunnable implements Runnable{
    private String name;

    public ImplRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + " " + i + "正在执行.....");
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
