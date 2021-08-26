package xieTest;

/**
 * 回文子串
 */

public class xie647 {
    public static void main(String[] args) {
        /**
         * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
         * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
         * */
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        int ans = n;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                dp[i][j] = (dp[i + 1][j - 1] || j - i < 2) && s.charAt(i) == s.charAt(j);
                if (dp[i][j]) ans++;
            }
        }
        return ans;
    }
}
