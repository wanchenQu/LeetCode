package LC100Collection.DP;

import java.util.Map;

/**
 * 最长回文子串
 */
public class xie5 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     */
    public static void main(String[] args) {
        String s = "ac";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int maxLength = 1;
        int ansL = 0;
        int n = s.length();
        if (n < 2) return s;
        char[] cs = s.toCharArray();
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                dp[i][j] = cs[i] == cs[j] && (dp[i + 1][j - 1] || j - i < 3);
                if (dp[i][j] && maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    ansL = i;
                }
            }
        }
        return s.substring(ansL, ansL + maxLength);
    }
}
