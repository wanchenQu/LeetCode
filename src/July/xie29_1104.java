package July;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树寻路
 */
public class xie29_1104 {
    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(14));
    }

    public static List<Integer> pathInZigZagTree(int n) {
        // n所在层
        int level = 1;
        while (getEnd(level) < n) level++;

        int[] ans = new int[level];
        int idx = level - 1, cur = n;
        while (idx >= 0) {
            ans[idx--] = cur;
            int tot = (int) Math.pow(2, level - 1);
            int start = getStart(level), end = getEnd(level);
            if (level % 2 == 0) {
                // 偶数层从右向左
                int j = tot / 2;
                for (int i = start; i <= end; i += 2, j--) {
                    if (i == cur || (i + 1) == cur) break;
                }
                int prevStart = getStart(level - 1);
                while (j-- > 1) prevStart++;
                cur = prevStart;
            } else {
                // 奇数层从左向右
                int j = 1;
                for (int i = start; i <= end; i += 2, j++) {
                    if (i == cur || (i + 1) == cur) break;
                }
                int prevEnd = getEnd(level - 1);
                while (j-- > 1) prevEnd--;
                cur = prevEnd;
            }
            level--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : ans) list.add(i);
        return list;
    }

    // level层起始节点值
    static int getStart(int level) {
        return (int) Math.pow(2, level - 1);
    }

    // level层结束节点值
    static int getEnd(int level) {
        int a = getStart(level);
        return a + a - 1;
    }
}

