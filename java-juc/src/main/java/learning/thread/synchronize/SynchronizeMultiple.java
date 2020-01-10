package learning.thread.synchronize;

import java.util.concurrent.TimeUnit;


public class SynchronizeMultiple {
    private int count = 0;
    public synchronized int synchronizedAdd() {//这里相当于synchronized(this)
        System.out.println(Thread.currentThread().getName() + " start");
        for (int j = 0; j < 10; j++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);//让其他线程有进入的机会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "：" + j + ", 当前count：" + count);
        }
        System.out.println(Thread.currentThread().getName() + " end");
        return count;
    }

    public synchronized int getCount() {//这里加了锁就会读取正确值，如果不加，则马上就会输出
        return count;
    }
}
