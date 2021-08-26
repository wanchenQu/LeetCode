package August;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 矩阵中战斗力最弱的 K 行
 */

public class xie1_1337 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 0},
                {0, 0},
                {1, 0}};
        int k = 2;
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int[] ans = new int[k];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < n; i++) {
            int[] tmp = mat[i];
            int l = 0, r = tmp.length - 1;
            while (l < r) {
                int m = l + r + 1 >>> 1;
                if (tmp[m] == 0) r = m - 1;
                else l = m;
            }
            q.add(new int[]{i, tmp[l] == 1 ? l + 1 : 0});
        }
        for (int i = 0; i < k; i++) {
            ans[i] = q.poll()[0];
        }
        return ans;
    }
}
