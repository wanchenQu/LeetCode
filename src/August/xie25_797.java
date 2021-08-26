package August;

import java.util.*;

/**
 * 所有可能的路径
 */

public class xie25_797 {
    static int N = 20, M = 400, idx, n;
    static int[] he = new int[N], ne = new int[M], e = new int[M];
    static int[][] graph;
    static List<List<Integer>> ans = new ArrayList<>();
    static Deque<Integer> cur = new ArrayDeque<>();

    public static void main(String[] args) {
        int[][] graph = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] _graph) {
        graph = _graph;
        n = graph.length;
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) for (int j : graph[i]) add(i, j);
        cur.add(0);
        dfs(0);
        return ans;
    }

    static void dfs(int x) {
        if (x == n - 1) ans.add(new ArrayList<>(cur));
        for (int i = he[x]; i != -1; i = ne[i]) {
            cur.addLast(e[i]);
            dfs(e[i]);
            cur.removeLast();
        }
    }

}
