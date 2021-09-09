package September;

/**
 * 斐波那契数列
 */

public class xie4_10_1 {
    static int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        System.out.println(fib(0));
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        long[][] a = new long[][]{
                {1},
                {0}
        };
        long[][] b = new long[][]{
                {1, 1},
                {1, 0}
        };
        int k = n - 1;
        while (k != 0) {
            if ((k & 1) == 1) a = matrixMul(b, a);
            b = matrixMul(b, b);
            k >>= 1;
        }
        return (int) a[0][0] % MOD;
    }

    static long[][] matrixMul(long[][] mA, long[][] mB) {
        int a = mA.length, b = mB.length, c = mB[0].length;
        long[][] ans = new long[a][c];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < b; k++) {
                    ans[i][j] += mA[i][k] * mB[k][j];
                    ans[i][j] %= MOD;
                }
            }
        }
        return ans;
    }
}
