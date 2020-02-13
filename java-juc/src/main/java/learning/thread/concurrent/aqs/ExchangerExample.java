package learning.thread.concurrent.aqs;

import learning.util.TimeUtil;

import java.util.concurrent.Exchanger;

/**
 * 这是在线程中交换数据
 *
 * 注意这里交换一定是双数的，单数的线程的时候，最后的那一个线程是不会交换的
 */
public class ExchangerExample {
    private Exchanger<String> exchanger = new Exchanger<>();
    public void testExchanger() {
        new Thread(() -> {
            String str = "第一个线程";
            try {
                String newStr = exchanger.exchange(str);
                System.out.println("第一个线程交换后的结果是：" + newStr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();


        TimeUtil.timeSleep(10);
        new Thread(() -> {
            String str = "第二个线程";
            try {
                String newStr = exchanger.exchange(str);
                System.out.println("第二个线程交换后的结果是：" + newStr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

//        new Thread(() -> {
//            String str = "第三个线程";
//            try {
//                String newStr = exchanger.exchange(str);
//                System.out.println("第三个线程交换后的结果是：" + str);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();
    }
}
