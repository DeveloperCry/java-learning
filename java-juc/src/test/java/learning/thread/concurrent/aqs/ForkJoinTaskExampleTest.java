package learning.thread.concurrent.aqs;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinTaskExampleTest {

    public static void main(String[] args) {
        ForkJoinPool forkjoinPool = new ForkJoinPool();

        //生成一个计算任务，计算1+2+3+4
        ForkJoinTaskExample task = new ForkJoinTaskExample(1, 10);

        //执行一个任务
        Future<Integer> result = forkjoinPool.submit(task);

        try {
            System.out.println("result:" + result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
