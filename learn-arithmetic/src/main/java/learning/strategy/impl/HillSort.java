package learning.strategy.impl;

import learning.strategy.ISort;

import java.util.Arrays;

public class HillSort implements ISort {
    @Override
    public void sort(int[] data) {
        System.out.println("原始：" + Arrays.toString(data));
        int group = data.length / 2;
        while (group > 0) {
            for (int i = group; i < data.length; i++) {
                int j = 0;
                int temp = data[i];
                for (j = i - group; j >= 0 && temp < data[j]; j = j - group) {
                    data[j + group] = data[j];
                    System.out.println("第" + i + "轮" + j + "插入：" + Arrays.toString(data));
                }
                data[j + group] = temp;
                System.out.println("第" + i + "轮：" + Arrays.toString(data));
            }
            group = group / 2;
        }

    }
}
