package June;

/**
 * 一和零
 */
public class xie6_474 {

    public static void main(String[] args) {
        // 二进制字符串数组strs，m个0和n个1，找到strs的最大子集的大小
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(solution(strs, m, n));
    }

    public static int solution(String[] strs, int m, int n) {
        // 转化为01背包问题， 重量限制为count0 <= m, count1 <= n, 每个元素的价值贡献为1
        int len = strs.length;
        int[][] count10 = new int[len][2];
        for (int i = 0; i < len; i++) {
            String str = strs[i];
            int count0 = 0;
            int count1 = 0;
            for (char c :
                    str.toCharArray()) {
                if (c == '0' ) {
                    count0++;
                } else {
                    count1++;
                }
            }
            count10[i] = new int[]{count0, count1};
        }

        int[][][] dp = new int[len][m + 1][n + 1];
        // 处理第一个元素
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[0][i][j] = (i >= count10[0][0] && j >= count10[0][1]) ? 1 : 0;
            }
        }
        for (int k = 1; k < len; k++) {
            int zeroCount = count10[k][0];
            int oneCount = count10[k][1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[k][i][j] = Math.max(dp[k - 1][i][j], (i >= zeroCount && j >= oneCount) ? (dp[k - 1][i - zeroCount][j - oneCount] + 1) : 0);
                }
            }
        }
        return dp[len - 1][m][n];
    }
}
