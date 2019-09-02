package learning.strategy.impl;

import learning.strategy.ISort;

import java.util.Arrays;

/**
 * 这里与冒泡排序的区别在于，冒泡排序每次都是找到最小的，然后将数往上面冒泡；
 * 而插入排序是设定一个数，然后从这个数的位置之前与之比较，如果这个数与前面的数小，那么前面的数都往后面移动一位，知道找到比它大的数为止，然后插入
 */
public class InsertSort implements ISort {
    @Override
    public void sort(int[] data) {
        System.out.println("原始：" + Arrays.toString(data));
        for (int i = 1 ; i < data.length; i ++) {
            int j = 0;
            int temp = data[i];
            for (j = i - 1; j >= 0 && temp < data[j]; j --) {
                data[j + 1] = data[j];
                System.out.println("第" + i + "轮" + j + "插入：" + Arrays.toString(data));
            }
            data[j + 1] = temp;
            System.out.println("第" + i + "轮：" + Arrays.toString(data));
        }
    }
}
