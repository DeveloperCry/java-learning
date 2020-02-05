package learning.thread.concurrent.atomics;

import learning.entity.User;
import lombok.Getter;

import java.util.concurrent.atomic.*;

@Getter
public class Atomic {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    // 被更改的属性必须是public，volatile的属性，比如这里的age
    private AtomicIntegerFieldUpdater<User> updater =  AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
    // 当需要更新或是交换值得时候就要用该类
    private AtomicReference<Integer> atomicReference = new AtomicReference<>(0);
    private AtomicLong atomicLong = new AtomicLong(0L);
    // 在初始化的时候会接受一个钩子函数和一个初始化值， 这个钩子函数决定了如何来运算，具体实现由accumulate方法来执行该钩子函数。
    // LongAccumulator可以提供累加器初始非0值，后者只能默认为0
    // 注意，如果计算结果超出long的取值范围，最后结果就会是0
    private LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x*y, 1L);
    private LongAdder longAdder = new LongAdder();

    private int i = 0;

    public void addAtomicInteger() {
        atomicInteger.addAndGet(1);
    }

    public void addAtomicLong() {
        atomicLong.incrementAndGet();
    }

    public void longAccumulator() {
        longAccumulator.accumulate(2L); // 传入的值会与上一次的比较值对比，然后保留较大者，最后打印出最大值。
    }

    public void addLongAdder() {
        longAdder.increment();
    }

    /**
     * 期望返回值是20
     */
    public void atomicReference() {
        atomicReference.compareAndSet(1, 2);
        atomicReference.compareAndSet(0, 4);
        atomicReference.compareAndSet(0, 5);
        atomicReference.compareAndSet(4, 20);
    }

    //期望值是100
    public void atomicIntegerFieldUpdater(User user) {
        updater.compareAndSet(user, 20, 30);
        updater.compareAndSet(user, 20, 40);
        updater.compareAndSet(user, 30, 100);
    }

    public void addInt() {
        i ++;
    }
}
