package LC100Collection.DP;

/**
 * 接雨水
 */
public class xie42 {
    public static void main(String[] args) {
        /**
         * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
         * */
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        System.out.println(trap(height));
    }

    public static int trap(int[] hs) {
        int ans = 0;
        int n = hs.length;
        int[] lm = new int[n];
        int[] rm = new int[n];
        for (int i = 1; i < n; i++) {
            lm[i] = Math.max(lm[i - 1], hs[i - 1]);
        }
        for (int j = n - 2; j >= 0; j--) {
            rm[j] = Math.max(rm[j + 1], hs[j + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            int temp = Math.min(lm[i], rm[i]);
            if (hs[i] < temp) {
                ans += temp - hs[i];
            }
        }
        return ans;
    }
}
