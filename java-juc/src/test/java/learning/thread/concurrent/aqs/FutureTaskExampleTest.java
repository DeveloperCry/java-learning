package learning.thread.concurrent.aqs;

import java.util.concurrent.ExecutionException;

public class FutureTaskExampleTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTaskExample example = new FutureTaskExample();
//        example.testFutureTask();
        example.testMyFutureTask();
    }
}
