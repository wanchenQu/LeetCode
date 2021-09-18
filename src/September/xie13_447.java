package September;

import java.util.HashMap;
import java.util.Map;

/**
 * 回旋镖的数量
 */

public class xie13_447 {
    public static void main(String[] args) {
        /**
         * 给定平面上n 对 互不相同 的点points ，其中 points[i] = [xi, yi] 。
         * 回旋镖 是由点(i, j, k) 表示的元组 ，其中i和j之间的距离和i和k之间的距离相等（需要考虑元组的顺序）。
         * */
        int[][] points = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int ans = 0, n = points.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1], dist = x * x + y * y;
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            /**
             * 在n条相同长度的边中选2条，有顺序*2
             * 2 * Cn2 = n * n - 1
             * */
            for (int k : map.keySet()) {
                int dist = map.get(k);
                ans += dist * (dist - 1);
            }
            map.clear();
        }
        return ans;
    }
}
