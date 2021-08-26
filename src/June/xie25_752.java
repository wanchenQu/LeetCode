package June;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为'0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 */
public class xie25_752 {
    static String l, r;
    static Set<String> set = new HashSet<>();
    static int[] turn = new int[]{-1, 1};

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        // 初始数字为'0000'
        String target = "0000";
        System.out.println(openLock(deadends, target));
    }

    public static int openLock(String[] deadends, String target) {
        l = "0000";
        r = target;
        if (l.equals(target)) {
            return 0;
        }
        for (String s :
                deadends) {
            set.add(s);
        }
        if (set.contains(l)) {
            return -1;
        }
        int result = bfs();
        return result == -1 ? 0 : result;


    }

    private static int bfs() {
        Deque<String> l2rq = new ArrayDeque<>(), r2lq = new ArrayDeque<>();
        Map<String, Integer> l2rM = new HashMap<>(), r2lM = new HashMap<>();
        l2rq.add(l);
        r2lq.add(r);
        l2rM.put(l, 0);
        r2lM.put(r, 0);
        while (!l2rq.isEmpty() && !r2lq.isEmpty()) {
            int t = -1;
            if (l2rq.size() <= r2lq.size()) {
                t = process(l2rq, l2rM, r2lM);
            } else {
                t = process(r2lq, r2lM, l2rM);
            }
            if (t != -1) {
                return t;
            }
        }
        return -1;
    }

    private static int process(Deque<String> Q, Map<String, Integer> I, Map<String, Integer> U) {
        String cur = Q.poll();
        for (int i = 0; i < 4; i++) {
            for (int j :
                    turn) {
                int t = Integer.valueOf(cur.charAt(i) - '0') + j;
                String temp = cur.substring(0, i) + String.valueOf(t == -1 ? 9 : t) + cur.substring(i + 1);
                if (!set.contains(temp)) {
                    if (I.containsKey(temp)) {
                        continue;
                    }
                    if (U.containsKey(temp)) {
                        return I.get(cur) + U.get(temp) + 1;
                    } else {
                        Q.add(temp);
                        I.put(temp, I.get(cur) + 1);
                    }
                }
            }
        }
        return -1;
    }
}
