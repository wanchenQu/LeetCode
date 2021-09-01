package LC100Collection.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 */

public class xie22 {
    static List<String> ans = new ArrayList<>();
    static int n;

    public static void main(String[] args) {
        /**
         * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
         * 有效括号组合需满足：左括号必须以正确的顺序闭合。
         * */
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int _n) {
        n = _n;
        dfs("", 0, 0);
        return ans;
    }

    static void dfs(String cur, int lc, int rc) {
        if (lc == n && rc == n) {
            ans.add(cur);
            return;
        }
        if (lc < rc) return;
        if (lc < n) dfs(cur + '(', lc + 1, rc);
        if (rc < n) dfs(cur + ')', lc, rc + 1);
    }
}
