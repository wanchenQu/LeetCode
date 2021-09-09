package September;

/**
 * 分割平衡字符串
 */

public class xie7_1221 {
    public static void main(String[] args) {
        String s = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int a = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') a++;
            else a--;
            if (a == 0) ans++;
        }
        return ans;
    }
}
