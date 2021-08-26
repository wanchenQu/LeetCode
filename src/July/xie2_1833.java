package July;

import java.util.Arrays;

/**
 * 雪糕的最大数量
 */
public class xie2_1833 {
    public static void main(String[] args) {
        /**
         * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
         * 注意：Tony 可以按任意顺序购买雪糕。
         * */
        int[] costs = new int[]{10, 6, 8, 7, 7, 8};

        int coins = 5;
        System.out.println(maxIceCream(costs, coins));
    }

    public static int maxIceCream(int[] cs, int t) {
        Arrays.sort(cs);
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            if (t >= cs[i]) {
                ans++;
                t -= cs[i];
            }
        }
        return ans;
    }
}
