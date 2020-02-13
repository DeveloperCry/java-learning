package learning.thread.concurrent.aqs;

import learning.util.TimeUtil;

import java.util.concurrent.*;

/**
 * 一个可取消的异步计算。这个类提供了一个Future的基本实现，使用一些方法来启动和取消一个计算，查询以查看计算是否完成，并检索计算的结果。
 * 只有在计算完成后，才可检索结果;如果计算尚未完成，get方法将阻塞。一旦计算完成，就不能重新启动或取消计算(除非使用runAndReset()调用计算)。
 *
 * runAndReset()方法：在不设置结果的情况下执行计算，然后将这个future重置为初始状态，如果计算遇到异常或被取消，则无法这样做。
 * 这是为本质上执行多次的任务而设计的。
 */
public class FutureTaskExample {
    private int count = 0;
    private int myCount = 0;

    public void testFutureTask() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            TimeUtil.timeSleep(2);
            add();
            System.out.println("执行future task：" + count);
            return "future task 结果" + count;
        });
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 10000; i++) {
            service.submit(futureTask);
//            new Thread(futureTask).start();
            String result = futureTask.get();
            System.out.println(i + "结果是：" + result);
        }
        service.shutdown();
        System.out.println("执行结束");
    }

    private synchronized void add() {
        count ++;
    }

    public void testMyFutureTask() throws ExecutionException, InterruptedException {
        MyFutureTask<String> futureTask = new MyFutureTask<>(() -> {
            TimeUtil.timeSleep(2);
            addMyCount();
            System.out.println("执行my future task：" + myCount);
            return "my future task 结果" + myCount;
        });
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            service.submit(futureTask);

            System.out.println("重置" + futureTask.runAndReset());
//            String result = futureTask.get(); // 这里不能调用get方法，否则runAndReset不起作用。
            System.out.println(i + "结果是：");
        }
        service.shutdown();
        System.out.println("my future task执行结束");
    }

    private synchronized void addMyCount() {
        myCount ++;
    }

    class MyFutureTask<T> extends FutureTask<T> {

        public MyFutureTask(Callable<T> callable) {
            super(callable);
        }

        public boolean runAndReset() {
            System.out.println("执行重置方法");
            return super.runAndReset();
        }
    }
}
