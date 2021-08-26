package LC100Collection.DP;

import java.util.Arrays;

/**
 * 比特位计数
 */

public class xie338 {
    public static void main(String[] args) {
        /**
         * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
         * 计算其二进制数中的 1 的数目并将它们作为数组返回。
         * */
        System.out.println(Arrays.toString(countBits(10)));
        System.out.println(Arrays.toString(countBits2(10)));

    }

    public static int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) ans[i] = ans[i >> 1];
            else ans[i] = ans[i - 1] + 1;
        }
        return ans;
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = bitCount(i);
        }
        return ans;
    }

    static int bitCount(int a) {
        int ans = 0;
        while (a != 0) {
            a -= (a & -a);
            ans++;
        }
        return ans;
    }

}
