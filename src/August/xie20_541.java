package August;

/**
 * 反转字符串2
 */

public class xie20_541 {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int a = n / (2 * k);
        int b = n % (2 * k);
        for (int i = 1; i <= a; i++) {
            int l = 2 * i * k - 2 * k;
            int r = 2 * i * k - k - 1;
            helper(cs, l, r);
        }
        int l = a * 2 * k;
        if (b < k) helper(cs, l, n - 1);
        if (b >= k) helper(cs, l, l + k -1);
        return String.valueOf(cs);
    }

    public static void helper(char[] cs, int l, int r) {
        while (l < r) {
            char tmp = cs[l];
            cs[l] = cs[r];
            cs[r] = tmp;
            l++;
            r--;
        }
    }
}
