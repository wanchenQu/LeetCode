package xieTest;

import java.util.*;

/**
 * 课程表2
 */

public class xie210 {
    static int N = 100010, M = 5010, idx;
    static int[] he = new int[N], e = new int[M], ne = new int[M];

    public static void main(String[] args) {
        /**
         * 现在你总共有 n 门课需要选，记为0到n-1。
         * 在选修某些课程之前需要一些先修课程。例如，想要学习课程 0 ，你需要先完成课程1 ，
         * 我们用一个匹配来表示他们: [0,1]
         * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
         * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
         * */
        int cs = 3;
        //int[][] ps = new int[][]{{1, 0}};
        int[][] ps = new int[][]{{2, 0}, {2, 1}};

        System.out.println(Arrays.toString(findOrder(cs, ps)));
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) ans[i] = i;
            return ans;
        }
        boolean[] b = new boolean[numCourses];
        int[] ic = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        Arrays.fill(he, -1);

        for (int[] p : prerequisites) {
            b[p[0]] = b[p[1]] = true;
            add(p[1], p[0]);
            ic[p[0]]++;
        }
        for (int i = 0; i < numCourses; i++) if (!b[i]) ans.add(i);
        int start = -1;
        for (int i = 0; i < numCourses; i++) {
            if (ic[i] == 0) {
                start = i;
                q.add(start);
            }
        }
        if (start == -1) return new int[]{};
        while (!q.isEmpty()) {
            int poll = q.pollFirst();
            if (b[poll]) ans.add(poll);
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--ic[j] == 0) q.addLast(j);
            }
        }
        for (int i : ic) if (i != 0) return new int[]{};
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
