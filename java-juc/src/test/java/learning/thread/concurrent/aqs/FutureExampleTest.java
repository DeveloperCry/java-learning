package learning.thread.concurrent.aqs;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExampleTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            Future<String> future = service.submit(new FutureExample());

            System.out.println("这个是第" + i + "个for循环");
            String result = future.get();
            System.out.println("结果是：" + result);
        }
        System.out.println("这个是主函数");


        service.shutdown();
    }
}
