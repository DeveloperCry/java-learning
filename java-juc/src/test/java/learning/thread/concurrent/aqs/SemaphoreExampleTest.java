package learning.thread.concurrent.aqs;

public class SemaphoreExampleTest {
    public static void main(String[] args) {
        SemaphoreExample example = new SemaphoreExample();
        example.testSemaphore();
        example.testTrySemaphore();
    }
}
