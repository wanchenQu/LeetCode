package LC100Collection.DP;

/**
 * 跳跃游戏
 */
public class xie55 {
    public static void main(String[] args) {
        /**
         * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
         * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
         * 判断你是否能够到达最后一个下标。
         * */
        int[] nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
        System.out.println(solution(nums));

    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n < 2) return true;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                }
            }
        }
        return dp[n - 1];
    }

    public static boolean solution(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }

}
