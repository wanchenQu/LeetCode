package xieTest;

/**
 * 丑数
 */

public class xie263 {
    static int[] s = new int[]{2, 3, 5};

    /**
     * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
     * 丑数 就是只包含质因数2、3 和/或5的正整数。
     */
    public static void main(String[] args) {
        int[] a = new int[]{1, 6, 8, 14};
        for (int c : a) System.out.println(isUgly(c));
    }

    public static boolean isUgly(int n) {
        if (n <= 0) return false;
        for (int i : s) {
            while (n % i == 0) {
                n /= i;
            }
        }
        return n == 1;
    }
}
