package July;

import java.util.*;

/**
 * 从相邻元素对还原数组
 */
public class xie25_1743 {
    public static void main(String[] args) {
        int[][] adjacentPairs = new int[][]{{2, 1}, {3, 4}, {3, 2}};
        System.out.println(Arrays.toString(restoreArray(adjacentPairs)));
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            int f = pair[0], t = pair[1];
            count.put(f, count.getOrDefault(f, 0) + 1);
            count.put(t, count.getOrDefault(t, 0) + 1);
            List<Integer> fList = map.getOrDefault(f, new ArrayList<>());
            fList.add(t);
            map.put(f, fList);
            List<Integer> tList = map.getOrDefault(t, new ArrayList<>());
            tList.add(f);
            map.put(t, tList);
        }
        int start = -1;
        for (int i : count.keySet()) {
            if (count.get(i) == 1) {
                start = i;
                break;
            }
        }
        int n = adjacentPairs.length;
        int[] ans = new int[n + 1];
        ans[0] = start;
        ans[1] = map.get(start).get(0);
        for (int i = 2; i <= n; i++) {
            int pre = ans[i - 1];
            List<Integer> list = map.get(pre);
            for (int j : list) {
                if (j != ans[i - 2]) {
                    ans[i] = j;
                }
            }
        }
        return ans;
    }
}
