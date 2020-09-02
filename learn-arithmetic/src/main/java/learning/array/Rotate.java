package learning.array;

public class Rotate {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6,7};
        int[] nums = {-1,-100,3,99};
        rotate(nums, 3);
        System.out.println("====");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 7-3 = 4
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int move = k % nums.length;
        int remain = nums.length - move;
        int[] temp = new int[remain];
        for (int i = 0; i < remain; i++) {
            temp[i] = nums[i];
        }

        for (int i = 0; i < move; i++) {
            nums[i] = nums[remain + i];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[move + i] = temp[i];
        }

    }
}
