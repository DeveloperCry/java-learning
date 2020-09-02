package learning.array;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12,0,2};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 通过指针来控制
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int pointer = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (pointer < 0) {
                    pointer = i;
                }
            } else {
                if (pointer != i && pointer >= 0) {
                    nums[pointer] = nums[i];
                    nums[i] = 0;
                    pointer ++;
                }
            }
        }
    }
}
