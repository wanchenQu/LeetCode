package September;

/**
 * Nim游戏
 */

public class xie18_292 {
    public static void main(String[] args) {
        /**
         * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。
         * 你作为先手, 如果可以赢，返回 true；否则，返回 false
         * */
        System.out.println(canWinNim(8));
    }

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
