package learning.strategy.impl;

import learning.strategy.ISort;

import java.util.Arrays;

public class HeapSort implements ISort {
    @Override
    public void sort(int[] data) {
        System.out.println("原始：" + Arrays.toString(data));
        this.initHeap(data);
        System.out.println("初始堆：-----" + Arrays.toString(data));

        for (int i = data.length - 1; i > 0; i --) {
            this.swap(data, 0, i);

            this.updateHeap(data, 0, i);
            System.out.println("第" + i + "轮：" + Arrays.toString(data));
        }
    }

    private void initHeap(int[] data) {
        for (int i = data.length / 2; i >= 0; i --) {
            this.updateHeap(data, i, data.length);
        }
    }

    //法1
    private void updateHeap(int[] data, int currentNode, int length) {
        int temp = data[currentNode];
        int child = currentNode * 2 + 1;

        while (child < length) {
            if (child + 1 < length && data[child] < data[child + 1]) {
                child ++;
            }

            if (temp > data[child]) {
                break;
            }

            data[currentNode] = data[child];
            currentNode = child;
            child = currentNode * 2 + 1;
        }
        data[currentNode] = temp;
    }

    //法2
//    private void updateHeap(int[] data, int currentNode, int length) {
//        int temp = data[currentNode];
//        int leftChild = currentNode * 2 + 1;
//        int rightChild = currentNode * 2 + 2;
//
//        int max = currentNode;
//
//        if (leftChild < length && temp < data[leftChild]) {
//            max = leftChild;
//        }
//
//        if (rightChild < length && temp < data[rightChild] && data[leftChild] < data[rightChild]) {
//            max = rightChild;
//        }
//
//        if (max != currentNode) {
//            this.swap(data, currentNode, max);
//            updateHeap(data, max, length);
//        }
//    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
