package learning.thread.startathread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableThreadTest {
    public static void main(String[] args) {
        CallableThread thread = new CallableThread();
        FutureTask<Boolean> task = new FutureTask<Boolean>(thread);

        Thread th = new Thread(task);
        th.start();

        System.out.println("我可以在这里做点别的业务逻辑...因为FutureTask是提前完成任务");
        //拿出线程执行的返回值
        Boolean result = null;
        try {
            result = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程中运算的结果为:" + result);
    }
}
