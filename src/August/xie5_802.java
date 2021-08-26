package August;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到最终的安全状态
 */

public class xie5_802 {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{}, {0, 2, 3, 4}, {3}, {4}, {}};
        System.out.println(eventualSafeNodes(graph));
    }


    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (safe(graph, color, i)) ans.add(i);
        }

        return ans;
    }

    public static boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) return color[x] == 2;
        color[x] = 1;
        for (int i : graph[x]) {
            if (!safe(graph, color, i)) return false;
        }
        color[x] = 2;
        return true;
    }
}
