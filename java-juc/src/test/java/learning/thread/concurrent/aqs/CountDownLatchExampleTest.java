package learning.thread.concurrent.aqs;

public class CountDownLatchExampleTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatchExample example = new CountDownLatchExample();
        example.testWait();
        example.testWaitTime();
        example.testAPIExample();
        example.testCountDown();
    }
}
