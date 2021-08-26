package LC100Collection.DP;

/**
 * 最大子序和
 */
public class xie53 {
    public static void main(String[] args) {
        /**给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。*/
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return 0;
        int ans = nums[0];
        int[] dp = new int[2];
        dp[0] = ans;
        for (int i = 1; i < n; i++) {
            dp[i & 1] = Math.max(dp[(i - 1) & 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i & 1]);
        }
        return ans;
    }
}
