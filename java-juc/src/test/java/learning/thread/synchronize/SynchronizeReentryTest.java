package learning.thread.synchronize;

public class SynchronizeReentryTest {
    public static void main(String[] args) {
        SynchronizeReentry method = new SynchronizeReentry();
        new Thread(method::synchronizedAdd/*, "同步线程线程"*/).start();
    }
}
