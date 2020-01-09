package learning.thread.startathread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerThread {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.format("运行次数%d\n", i + 1);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 0, 1);
    }
}
