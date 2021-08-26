package August;

/**
 * 数字1的个数
 */

public class xie13_233 {
    public static void main(String[] args) {
        /**
         * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
         * 0 <= n <= 2 * 109
         * */
        int n = 1;
        System.out.println(countDigitOne(n));
    }

    public static int countDigitOne(int n) {
        int high = n / 10, cur = n % 10, low = 0, digit = 1, ans = 0;
        while (digit <= n) {
            if (cur == 0) ans += (high * digit);
            else if (cur == 1) ans += (high * digit + low + 1);
            else ans += ((high + 1) * digit);
            low += cur * digit;
            cur = high % 10;
            digit *= 10;
            high /= 10;
        }
        return ans;
    }

}
