package July;

import java.util.*;

/**
 * 传递信息
 */
public class xie1_LCP07 {
    static int n;
    static int ans;
    static int k;
    static Map<Integer, Set<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        /**
         * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
         * */
        int n = 5;
        int[][] relation = new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int k = 3;
        System.out.println(numWaysDP(n, relation, k));
        System.out.println(numWaysDFS(n, relation, k));
        System.out.println(numWaysBFS(n, relation, k));

    }

    public static int numWaysDP(int n, int[][] rs, int k) {
        // dp数组定义:dp[i][j]通过i步传递到j玩家
        // 状态转移方程: dp[i][j] = SUM{dp[i-1][p]}, ([p, j] in relation)
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] r : rs) {
                int a = r[0], b = r[1];
                dp[i][b] += dp[i - 1][a];
            }
        }
        return dp[k][n - 1];
    }

    public static int numWaysBFS(int n, int[][] rs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] r : rs) {
            int a = r[0], b = r[1];
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0);
        while (!q.isEmpty() && k-- > 0) {
            int size = q.size();
            while (size-- > 0) {
                int poll = q.pollFirst();
                Set<Integer> nexts = map.get(poll);
                if (nexts == null) continue;
                for (int next : nexts) {
                    q.addLast(next);
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            if (q.pollFirst() == n - 1) ans++;
        }
        return ans;
    }

    public static int numWaysDFS(int _n, int[][] rs, int _k) {
        n = _n;
        k = _k;
        for (int[] r : rs) {
            int a = r[0], b = r[1];
            Set<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
        }
        dfs(0, 0);
        return ans;
    }

    static void dfs(int cur, int steps) {
        if (steps == k) {
            if (cur == n - 1) ans++;
            return;
        }
        Set<Integer> set = map.get(cur);
        if (set == null) return;
        for (int next : set) {
            dfs(next, steps + 1);
        }
    }
}
