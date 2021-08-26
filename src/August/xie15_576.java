package August;

/**
 * 出界的路径数
 */

public class xie15_576 {
    public static void main(String[] args) {
        /**
         * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。
         * 你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
         * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，
         * 找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
         * */
        System.out.println(findPaths(2, 2, 2, 0, 0));
    }

    static int loc(int x, int y, int z) {
        return x * z + y;
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int MOD = (int) 1e9 + 7;
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int[] dp = new int[m * n];;
        for (int k = 1; k <= maxMove; k++) {
            int[] tmp = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int cur = loc(i, j, n);
                    if (i == 0) tmp[cur]++;
                    if (j == 0) tmp[cur]++;
                    if (i == m - 1) tmp[cur]++;
                    if (j == n - 1) tmp[cur]++;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        int pre = loc(x, y, n);
                        if (x >= 0 && x < m && y >= 0 && y < n) tmp[cur] = (tmp[cur] + dp[pre]) % MOD;
                    }
                }
            }
            dp = tmp;
        }
        return dp[loc(startRow, startColumn, n)];
    }
}
