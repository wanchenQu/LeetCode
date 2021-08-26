package August;

import java.util.Arrays;

/**
 * 等差数列划分
 */

public class xie10_413 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 8, 9, 10};
        System.out.println(numberOfArithmeticSlices(nums));
        System.out.println(numberOfArithmeticSlices2(nums));

    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[] dp = new int[n];
        int ans = 0;
        dp[0] = dp[1] = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }

    public static int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int ans = 0;
        for (int i = 0; i < n - 2; ) {
            int dif = nums[i + 1] - nums[i];
            int l = i, r = i;
            while (r + 1 < n && nums[r + 1] - nums[r] == dif) r++;
            int a = r - l - 1;
            ans += (1 + a) * a / 2;
            i = r;
        }
        return ans;
    }
}