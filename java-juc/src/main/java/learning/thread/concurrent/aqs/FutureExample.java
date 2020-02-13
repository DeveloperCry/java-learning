package learning.thread.concurrent.aqs;

import learning.util.TimeUtil;

import java.util.concurrent.Callable;

/**
 * Future 有阻塞的作用
 *
 * fFuture.get 如果需要，则等待计算完成，然后检索其结果。
 *
 */
public class FutureExample implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUtil.timeSleep(2);
        System.out.println("这个是个future");
        return "这就是结果";
    }
}
