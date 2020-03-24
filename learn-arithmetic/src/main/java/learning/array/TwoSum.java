package learning.array;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        System.out.println(twoSum(nums, 9));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for(int i = 0; i < nums.length - 1; i ++) {
            for(int j = 1; j < nums.length; j ++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;

    }
}
