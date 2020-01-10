package learning.thread.synchronize;

public class SynchronizeMixtureTest {
    public static void main(String[] args) {
        SynchronizeMixture method = new SynchronizeMixture();
        for (int i = 0; i < 5; i++) {
            new Thread(method::synchronizedAdd, "同步线程线程" + i).start();
            new Thread(method::noSynchronizedAdd, "非同步线程线程" + i).start();
        }
    }
}
