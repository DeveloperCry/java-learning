package learning.thread.concurrent.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 这个锁允许读取器和写入器以ReentrantLock的形式重新获取读或写锁。在写线程持有的所有写锁都被释放之前，不可重入读取器是不允许的。
 *
 * 此外，写入器可以获得读锁，但反之则不行。在其他应用程序中，可重入性在对在读锁下执行读的方法的调用或回调期间保持写锁时非常有用。
 * 如果一个读取器试图获取写锁，它将永远不会成功。
 */
public class ReentrantReadWriteLockExample {
    final ReentrantLock reentrantLock = new ReentrantLock();
    final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    final Lock readLock = lock.readLock();
    final Lock writeLock = lock.writeLock();

    private int count = 0;
    private List<String> list = new ArrayList<>();

    public void display() {
        try{

            readLock.lock();
//            reentrantLock.lock();
            Thread.sleep(1000);
            System.out.println("开始读取数据========");
            list.stream().forEach((data) -> System.out.println(data));
            System.out.println("读取数据完成========");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
//            reentrantLock.unlock();
        }
    }

    public void add(String str) {
        try{

            writeLock.lock();
//            reentrantLock.lock();
            Thread.sleep(1000);
            list.add(str);
            System.out.println("写入数据完成：" + str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
//            reentrantLock.unlock();
        }

    }
}
