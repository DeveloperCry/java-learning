package learning.thread;

public class ImplRunnableTest {
    public static void main(String[] args) {
        Thread d1 = new Thread(new ImplRunnable("线程1"));
        Thread d2 = new Thread(new ImplRunnable("线程2"), "线程22");

        d1.start();
        d2.start();
        System.out.println(d2.getName());
    }

}
