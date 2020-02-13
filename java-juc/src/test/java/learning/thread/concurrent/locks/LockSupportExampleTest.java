package learning.thread.concurrent.locks;

import java.util.concurrent.locks.LockSupport;

public class LockSupportExampleTest {
    public static void main(String[] args) {
        LockSupportExample example = new LockSupportExample();
        example.testLockSupport();
    }
}
