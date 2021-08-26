package August;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计不开心的朋友
 */

public class xie14_1583 {
    static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        /**
         * 在 x 与 y 配对且 u 与 v 配对的情况下，如果同时满足下述两个条件，x 就会不开心：
         * x 与 u 的亲近程度胜过 x 与 y，且
         * u 与 x 的亲近程度胜过 u 与 v
         * */
        int n = 4;
        int[][] preferences = new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}},
                pairs = new int[][]{{0, 1}, {2, 3}};
        System.out.println(unhappyFriends(n, preferences, pairs));

    }

    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int m = pairs.length;
        for (int i = 0; i < n; i++) {
            int[] p = preferences[i];
            Map<Integer, Integer> tmp = new HashMap<>();
            for (int j = 0; j < n - 1; j++) tmp.put(p[j], n - j);
            map.put(i, tmp);
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int x = pairs[i][0], y = pairs[i][1];
            boolean xNH = false, yNH = false;
            for (int j = 0; j < m; j++) {
                if (i == j) continue;
                int u = pairs[j][0], v = pairs[j][1];
                if (!xNH && check(x, y, u, v)) xNH = true;
                if (!yNH && check(y, x, u, v)) yNH = true;
                if (xNH && yNH) break;
            }
            if (xNH) ans++;
            if (yNH) ans++;
        }
        return ans;
    }

    static boolean check(int x, int y, int u, int v) {
        Map<Integer, Integer> xmap = map.get(x), umap = map.get(u), vmap = map.get(v);
        if (xmap.get(u) > xmap.get(y) && umap.get(x) > umap.get(v)) return true;
        if (xmap.get(v) > xmap.get(y) && vmap.get(x) > vmap.get(u)) return true;
        return false;
    }
}
