package learning.strategy.impl;

import learning.strategy.ISort;

import java.util.Arrays;

/**
 * 循环这些数，从倒数第一个开始找，找到小的数，就往上冒泡，由于i前面已经排好序了，所以不用找i前面的了，这也是为什么j>i的原因
 */
public class BetterBubblingSort implements ISort {
    boolean hasChange = false;
    @Override
    public void sort(int[] data) {
        System.out.println("原始：" + Arrays.toString(data));
        for (int i = 0; i < data.length - 1 ; i++) {
            hasChange = false;
            for (int j = data.length - 1; j > i ; j--) {
                if (data[j - 1] > data[j]) {//升序用>,降序用<
                    int temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;
                    hasChange = true;
                }
            }
            System.out.println("第" + i + "轮：" + Arrays.toString(data));
            if (!hasChange) {//说明已经是有序的了，所以才不用交换
                break;
            }
        }
    }
}
