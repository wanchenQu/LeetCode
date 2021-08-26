package August;

/**
 * 学生出勤记录2
 */

public class xie18_552 {
    static int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        /**
         * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
         * 'A'：Absent，缺勤
         * 'L'：Late，迟到
         * 'P'：Present，到场
         * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
         * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
         * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
         * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况数量。
         * 答案可能很大，所以返回对 109 + 7 取余 的结果。
         * */
        int n = 10101;//183236316
        System.out.println(checkRecord(n));
        System.out.println(checkRecord2(n));
    }

    public static int checkRecord(int n) {
        long[][] dp = new long[2][6];
        dp[0][0] = dp[0][1] = dp[0][3] = 1;
        for (int i = 1; i < n; i++) {
            int a = i & 1, b = i - 1 & 1;
            dp[a][0] = (dp[b][0] + dp[b][1] + dp[b][2]) % MOD;
            dp[a][3] = (dp[b][3] + dp[b][4] + dp[b][5] + dp[b][0] + dp[b][1] + dp[b][2]) % MOD;
            dp[a][1] = dp[b][0];
            dp[a][2] = dp[b][1];
            dp[a][4] = dp[b][3];
            dp[a][5] = dp[b][4];
        }
        int c = n - 1 & 1;
        long ans = (dp[c][0] + dp[c][1] + dp[c][2] + dp[c][3] + dp[c][4] + dp[c][5]) % MOD;
        return (int) ans;
    }

    public static int checkRecord2(int n) {
        long[][] mat = new long[][]{
                {1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}
        };
        long[][] ans = new long[][]{
                {1},
                {1},
                {0},
                {1},
                {0},
                {0}
        };
        int k = n - 1;
        while (k != 0) {
            if ((k & 1) != 0) ans = mulM(mat, ans);
            mat = mulM(mat, mat);
            k >>= 1;
        }
        int res = 0;
        for (int i = 0; i < 6; i++) {
            res += ans[i][0];
            res %= MOD;
        }
        return res;
    }

    public static long[][] mulM(long[][] a, long[][] b) {
        int z = a.length, x = b[0].length, c = b.length;
        long ans[][] = new long[z][x];
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < c; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    ans[i][j] %= MOD;
                }
            }
        }
        return ans;
    }
}
