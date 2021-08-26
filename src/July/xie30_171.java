package July;

/**
 * EXECL表列序号
 */
public class xie30_171 {
    /**
     * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
     */
    public static void main(String[] args) {
        String s = "FXSHRXW";
        System.out.println(titleToNumber(s));
    }

    public static int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;
        for (char c : cs) {
            ans = ans * 26 + (c - 'A' + 1);
        }
        return ans;
    }
}
