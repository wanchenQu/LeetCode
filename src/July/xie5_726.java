package July;

import java.util.*;

/**
 * 原子的数量
 */
public class xie5_726 {
    static int i, n;
    static String s;

    /**
     * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推
     * 原子后面数字不能是1， 括号数字可以为空
     */
    public static void main(String[] args) {
        /**
         * 输入:
         * formula = "K4(ON(SO3)2)2"
         * 输出: "K4N2O14S4"
         * */
        String formula = "K4(ON(SO3)2)2";
        System.out.println(countOfAtoms(formula));
    }

    public static String countOfAtoms(String formula) {
        i = 0;
        n = formula.length();
        s = formula;
        Deque<Map<String, Integer>> stack = new LinkedList<>();
        stack.push(new HashMap<String, Integer>());
        while (i < n) {
            char c = s.charAt(i);
            if (c == '(') {
                i++;
                stack.push(new HashMap<String, Integer>());
            } else if (c == ')') {
                i++;
                int num = parseNum();
                Map<String, Integer> cur = stack.pop();
                Map<String, Integer> pre = stack.peek();
                for (Map.Entry<String, Integer> entry : cur.entrySet()) {
                    String key = entry.getKey();
                    int curCnt = entry.getValue();
                    pre.put(key, pre.getOrDefault(key, 0) + num * curCnt);
                }
            } else {
                String atomKey = parseAtom();
                int cnt = parseNum();
                Map<String, Integer> topMap = stack.peek();
                topMap.put(atomKey, topMap.getOrDefault(atomKey, 0) + cnt);
            }
        }
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String ansKey = entry.getKey();
            int ansCnt = entry.getValue();
            sb.append(ansKey);
            if (ansCnt > 1) {
                sb.append(ansCnt);
            }
        }
        return sb.toString();
    }

    private static String parseAtom() {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(i++));
        while (i < n && Character.isLowerCase(s.charAt(i))) {
            sb.append(s.charAt(i++));
        }
        return sb.toString();
    }

    private static int parseNum() {
        if (i == n || !Character.isDigit(s.charAt(i))) {
            return 1;
        }
        int num = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + s.charAt(i++) - '0';
        }
        return num;
    }

}
