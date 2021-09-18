package September;

/**
 * 不含连续1的非负整数
 */

public class xie11_600 {
    static int[] dp = new int[32];

    static {
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < 32; i++) dp[i] = dp[i - 1] + dp[i - 2];
    }

    public static void main(String[] args) {
        /**
         * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。
         * */
        System.out.println(findIntegers(12));
    }

    public static int findIntegers(int n) {
        int cur = 0, pre = 0;
        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                cur += dp[i];
                if (pre == 1) return cur;
                pre = 1;
            } else pre = 0;
        }
        return cur + 1;
    }
}
