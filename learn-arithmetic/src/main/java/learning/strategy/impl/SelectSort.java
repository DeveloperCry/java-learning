package learning.strategy.impl;

import learning.strategy.ISort;

import java.util.Arrays;

public class SelectSort implements ISort {
    @Override
    public void sort(int[] data) {
        System.out.println("原始：" + Arrays.toString(data));
        for (int i = 0; i < data.length - 1; i ++) {
            int index = i;
            for (int j = i + 1; j < data.length; j ++) {
                if (data[index] > data[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
            }
            System.out.println("第" + i + "轮：" + Arrays.toString(data));
        }
    }
}
