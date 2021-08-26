package LC100Collection.DP;

/**
 * 分割等和子集
 */

public class xie416 {
    public static void main(String[] args) {
        /**
         * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和【相等】。
         * */
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i : nums) sum += i;
        if ((sum & 1) == 1) return false;
        sum = sum >> 1;
        // 从nums中选择使得和为sum
        // dp[i][j]: 0 ~ i区间和为j
        // dp[i][j] = dp[i-1][j](不选i) || dp[i-1][j-nums[i]](选i)
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
