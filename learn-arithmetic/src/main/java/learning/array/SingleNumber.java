package learning.array;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        boolean isSingle = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i+1]) {
                if (isSingle) {
                    return nums[i];
                } else {
                    isSingle = true;
                }
            } else {
                isSingle = false;
            }
        }
        if (isSingle) {
            return nums[nums.length - 1];
        }
        return 0;
    }
}
