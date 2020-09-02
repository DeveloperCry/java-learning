package learning.array;

import java.util.Arrays;

public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] result = intersect(nums1, nums2);
        System.out.println("======================");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] exchange = {};
        if (nums1.length > nums2.length) {
            exchange = nums1;
            nums1 = nums2;
            nums2 = exchange;
        }
        int[] temp = new int[nums1.length];

        int index = 0;
        int next = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = next; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    temp[index++] = nums1[i];
                    next = j + 1;
                    break;
                }
            }
        }

        int[] result = new int[index];

        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }
}
