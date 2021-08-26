package xieTest;

import java.util.*;

/**
 * 课程表
 */

public class xie207 {
    static int N = 100010, M = 5010, idx;
    static int[] he = new int[N], e = new int[M], ne = new int[M];

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
    }


    /**
     * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，
     * 表示如果要学习课程ai 则 必须 先学习课程 bi 。
     * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     * 1 <= numCourses <= 10^5
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * prerequisites[i] 中的所有课程对 互不相同
     */
    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = new int[][]{{1, 4}, {2, 4}, {3, 2}, {3, 1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    public static boolean canFinish(int cs, int[][] ps) {
        if (ps == null || ps.length == 0) return true;
        Map<Integer, Integer> ic = new HashMap<>();
        Arrays.fill(he, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int p[] : ps) {
            // 入度+1
            ic.put(p[0], ic.getOrDefault(p[0], 0));
            ic.put(p[1], ic.getOrDefault(p[1], 0) + 1);
            // 图建边
            add(p[0], p[1]);
        }
        for (int i : ic.keySet()) if (ic.get(i) == 0) q.add(i);
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int i = he[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                int a = ic.get(j);
                ic.put(j, --a);
                if (a == 0) q.add(j);
            }
        }
        for (int i : ic.keySet()) if (ic.get(i) > 0) return false;
        return true;
    }
}
