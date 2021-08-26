package June;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 蛇形梯
 */
public class xie27_909 {
    static int n;
    static int[] nums;

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(snakesAndLadders(grid));
    }

    private static int bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        q.addLast(1);
        map.put(1, 0);
        while (!q.isEmpty()) {
            int poll = q.pollFirst();
            int step = map.get(poll);
            if (poll == n * n) {
                return step;
            }
            for (int i = 1; i <= 6; i++) {
                int np = poll + i;
                if (np <= 0 || np > n * n) {
                    continue;
                }
                if (nums[np] != -1) {
                    np = nums[np];
                }
                if (map.containsKey(np)) {
                    continue;
                }
                map.put(np, step + 1);
                q.addLast(np);
            }
        }
        return -1;
    }

    public static int snakesAndLadders(int[][] grid) {
        n = grid.length;
        if (grid[0][0] != -1) {
            return -1;
        }
        nums = new int[n * n + 1];
        boolean moveToRight = true;
        // 二维矩阵降维
        for (int i = n - 1, idx = 1; i >= 0; i--) {
            for (int j = (moveToRight ? 0 : n - 1); moveToRight ? j < n : j >= 0; j += moveToRight ? 1 : -1) {
                nums[idx++] = grid[i][j];
            }
            //转向遍历
            moveToRight = !moveToRight;
        }
        int result = bfs();
        return result;
    }
}