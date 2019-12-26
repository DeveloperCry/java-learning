package learning.thread;

public class LambdaThreadTest {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                System.out.println("正在执行.....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
