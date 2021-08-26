package July;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 天际线问题
 */
public class xie13_218 {
    public static void main(String[] args) {
        int[][] buildings = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkyline(buildings));
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {

        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> ps = new ArrayList<>();
        for (int[] b : buildings) {
            int l = b[0], r = b[1], h = b[2];
            ps.add(new int[]{l, -h});
            ps.add(new int[]{r, h});
        }
        Collections.sort(ps, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int prev = 0;
        q.add(prev);
        for (int[] p : ps) {
            int x = p[0], y = p[1];
            if (y < 0) q.add(-y);
            else q.remove(y);

            int cur = q.peek();
            if (cur != prev) {
                List<Integer> point = new ArrayList<>();
                point.add(x);
                point.add(cur);
                ans.add(point);
                prev = cur;
            }
        }

        return ans;
    }
}
