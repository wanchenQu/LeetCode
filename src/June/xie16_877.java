package June;

/**
 * 石子游戏
 */
public class xie16_877 {
    public static void main(String[] args) {
        int[] piles = new int[]{5, 3, 4, 5};
        System.out.println(solution(piles));
    }

    public static boolean solution(int[] piles) {
        // 通解
        // dp数组定义:dp[i][j]:从i到j堆拿石子当前选手的净胜分数
        // 状态转移方程：dp[i][j] = max{nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]}
        int len = piles.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len - 1] > 0;
    }
}
