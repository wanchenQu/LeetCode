package LC100Collection.DP;

/**
 * 最长递增子序列
 */
public class xie300 {
    public static void main(String[] args) {
        /**
         * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
         * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
         * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
         * */
        int[] nums = new int[]{7, 7, 7, 7, 7};

        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLISDP(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int p = 0;
        ans[p] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > ans[p]) ans[++p] = nums[i];
            else {
                int t = nums[i];
                int l = 0, r = p;
                while (l < r) {
                    int m = l + r >>> 1;
                    if (ans[m] < t) l = m + 1;
                    else r = m;
                }
                ans[l] = nums[i];
            }
        }
        return p + 1;
    }

    public static int lengthOfLISDP(int[] nums) {
        // dp[i]数组定义：以i元素结尾的最长递增子序列长度
        int n = nums.length;
        int ans = 1;
        if (n == 1) return ans;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], nums[i] > nums[j] ? dp[j] + 1 : 1);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
