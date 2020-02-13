package learning.thread.volatiles;

import lombok.Getter;

/**
 * Volatile 的作用就是：防止指令重排序，数据可见性
 */
@Getter
public class VolatileAction {
    private int count = 0;
    private volatile int volCount = 0;

    public void addCount() {
        count ++;
    }

    public void addVolCount() {
        volCount ++;
    }
}
