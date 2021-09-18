package September;

/**
 * 有效的括号字符串
 */

public class xie12_678 {
    public static void main(String[] args) {
        String s = "(*)";
        System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        /**
         * l 为最小可能分数， r 为最大可能分数
         * ( 权重为1， ) 权重为-1
         */
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
                r++;
            } else if (c == ')') {
                l--;
                r--;
            } else {
                l--;
                r++;
            }
            l = Math.max(l, 0);
            if (l > r) return false;
        }
        return l == 0;
    }

}
