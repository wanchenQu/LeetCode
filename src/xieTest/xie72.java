package xieTest;

/**
 * 编辑距离
 */

public class xie72 {
    public static void main(String[] args) {
        /**
         * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
         * 你可以对一个单词进行如下三种操作：
         * 插入一个字符
         * 删除一个字符
         * 替换一个字符
         * */
        String word1 = "intention", word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 1; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }
        }
        return dp[m][n];
    }
}
