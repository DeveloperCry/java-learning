package learning.thread.concurrent.aqs;

import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinTask是一个类似线程的实体，比一个正常的重量轻得多。
 * 在一个ForkJoinPool中，大量的任务和子任务可能由少量的实际线程来承载，这是以一些使用限制为代价的。
 */
public class ForkJoinTaskExample extends RecursiveTask {
    public static final int threshold = 2;
    private int start;
    private int end;

    public ForkJoinTaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;

        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= threshold;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinTaskExample leftTask = new ForkJoinTaskExample(start, middle);
            ForkJoinTaskExample rightTask = new ForkJoinTaskExample(middle + 1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            // 等待任务执行结束合并其结果
            Integer leftResult = (Integer) leftTask.join();
            Integer rightResult = (Integer) rightTask.join();

            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }
}
