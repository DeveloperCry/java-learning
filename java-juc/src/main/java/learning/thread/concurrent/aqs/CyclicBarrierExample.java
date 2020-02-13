package learning.thread.concurrent.aqs;

import learning.constant.Constants;
import learning.util.TimeUtil;
import lombok.Getter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一种同步辅助工具，允许一组线程彼此等待到达一个共同的障碍点。
 *
 * cyclicbarrier在包含固定大小的线程的程序中非常有用，这些线程有时必须彼此等待。
 * 这个屏障被称为循环屏障，因为它可以在等待的线程被释放后重新使用。
 *
 * CyclicBarrier支持一个可选的Runnable命令，该命令在每一个屏障点上运行一次，在最后一个线程到达之后，但是在释放任何线程之前。
 * 这个屏障动作对于在任何一方继续之前更新共享状态非常有用。
 *
 * 另外，虽说这个CyclicBarrier可以重置，但是请慎用
 */
@Getter
public class CyclicBarrierExample {

    private int count = 0;

    public void testCyclicBarrier() {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 9; i++) {
            TimeUtil.timeSleep(1);
            service.submit(() -> {
                try {
                    count ++;
                    System.out.println("开始：" + count);
                    barrier.await();
                    System.out.println("结束：" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
        System.out.println("当前count的值是：" + count);
    }

    public void testCyclicBarrierConstructor() {
        // 这里第二个参数的意思就是每当达到栅栏的时候，执行此参数给的线程
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("这个是初始化线程");
        });
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 9; i++) {
            TimeUtil.timeSleep(1);
            service.submit(() -> {
                try {
                    count ++;
                    System.out.println("开始：" + count);
                    barrier.await();
                    System.out.println("结束：" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
        System.out.println("当前count的值是：" + count);
    }
}
