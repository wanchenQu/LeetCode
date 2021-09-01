package August;

import java.util.Arrays;

/**
 * 一维数组的动态和
 */

public class xie28_1480 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 10, 1};
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    public static int[] runningSum(int[] nums) {
        int preSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum += nums[i];
            nums[i] = preSum;
        }
        return nums;
    }
}
