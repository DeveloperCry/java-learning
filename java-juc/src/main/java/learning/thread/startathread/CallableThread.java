package learning.thread.startathread;

import java.util.concurrent.Callable;

public class CallableThread implements Callable {
    @Override
    public Object call() throws Exception {
        boolean result = true;
        for (int i = 0; i < 10; i++) {
            System.out.format("运行次数%d\n", i + 1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
