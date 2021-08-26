package June;

/**
 * 二进制种1的个数
 */
public class xie23_O15 {
    /**
     * 请实现一个函数，输入一个整数（以二进制串形式）
     */
    public static void main(String[] args) {
        //输入必须是长度为32的二进制串
        int n = 00000000000000000000000010000000;
        System.out.println(solution1(n));
        System.out.println(solution2(n));
    }

    public static int solution1(int n) {
        int result = 0;
        while (n != 0) {
            n &= n - 1;
            result++;
        }
        return result;
    }

    public static int solution2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                result++;
            }
        }
        return result;
    }
}
