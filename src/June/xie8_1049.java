package June;

/**
 * 最后一块石头的重量2
 */
public class xie8_1049 {
    public static void main(String[] args) {
        // 一堆石头重量为stones[i] 任意选择两块石头碰撞粉碎
        // 剩余石头的最小重量
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        System.out.println(solution(stones));
    }

    public static int solution(int[] stones) {
        //小质量石头重量和为x，大质量石头重量和为sum-x，要求sum-x-x尽可能小，则x尽可能接近sum/2
        //转换问题为从stones[]中填满sum/2背包
        int sum = 0;
        for (int stone :
                stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int stone :
                stones) {
            for (int i = target; i >= stone; i--) {
                dp[i] = Math.max(dp[i], dp[i - stone] + stone);
            }
        }
        return sum - 2 * dp[target];
    }
}
