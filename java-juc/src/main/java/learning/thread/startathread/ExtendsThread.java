package learning.thread.startathread;

import java.util.concurrent.TimeUnit;

/**
 * 这是一个继承Thread的线程
 */
public class ExtendsThread extends Thread{

    public ExtendsThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(super.getName() + " " + i + "正在执行.....");
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
