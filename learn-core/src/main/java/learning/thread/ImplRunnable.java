package learning.thread;

public class ImplRunnable implements Runnable{
    private String name;

    public ImplRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.name + "正在执行.....");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
