package learning.thread.synchronize;

import java.util.concurrent.TimeUnit;

public class SynchronizeMultipleTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronizeMultiple method = new SynchronizeMultiple();
        new Thread(method::synchronizedAdd/*, "同步线程线程"*/).start();
        TimeUnit.MILLISECONDS.sleep(10);
        System.out.println("结果是：" + method.getCount());
    }
}
