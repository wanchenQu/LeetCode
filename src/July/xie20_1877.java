package July;

import java.util.Arrays;

/**
 * 数组中最大数对和的最小值
 */
public class xie20_1877 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 4, 2, 4, 6};
        System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            ans = Math.max(ans, nums[i] + nums[n - 1 - i]);
        }
        return ans;
    }
}
