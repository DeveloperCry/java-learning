package learning.strategy.impl;

import learning.strategy.ISort;

import java.util.Arrays;

public class QuickSort implements ISort {
    @Override
    public void sort(int[] data) {
        System.out.println("原始：" + Arrays.toString(data));
        this.quick(data, 0, data.length - 1);
        System.out.println("结果：" + Arrays.toString(data));
    }

    private void quick(int[] data, int left, int right) {
        if (left < right) {
            int index = this.getIndex(data, left, right);
            quick(data, 0, index - 1);
            quick(data, index + 1, right);
        }
    }

    private int getIndex(int[] data, int left, int right) {
        int temp = data[left];
        while (left < right) {
            while (left < right && temp <= data[right]) {
                right --;
            }
            data[left] = data[right];
            while (left < right && temp >= data[left]) {
                left ++;
            }
            data[right] = data[left];
        }
        data[left] = temp;
        return left;
    }
}
