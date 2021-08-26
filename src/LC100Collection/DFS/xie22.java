package LC100Collection.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */
public class xie22 {
    static int x;
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        /**
         * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
         * */
        int n = 3;
        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        x = n;
        dfs(0, 0, "");
        return ans;
    }

    /**
     * score: 左括号+1, 右括号-1
     * 检查到结果情况：idx遍历到末尾，且score = 0
     * 遍历过程中 score in [0, x]
     */
    private static void dfs(int idx, int score, String cur) {
        if (idx == 2 * x) {
            if (score == 0) ans.add(cur);
        } else {
            if (score + 1 <= x) {
                dfs(idx + 1, score + 1, cur + "(");
            }
            if (score - 1 >= 0) {
                dfs(idx + 1, score - 1, cur + ")");
            }
        }
    }
}
