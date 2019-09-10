package learning.thread;

public class ExtendsThread extends Thread{

    public ExtendsThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(super.getName() + "正在执行....." + interrupted());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
