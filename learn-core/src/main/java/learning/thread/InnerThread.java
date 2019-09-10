package learning.thread;

public class InnerThread {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("线程1" + "正在执行.....");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("线程2" + "正在执行.....");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("runnable run 线程执行了...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }){
            @Override
            public void run() {
                while (true) {
                    System.out.println("override run 线程执行了...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
