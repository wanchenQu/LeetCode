package June;

/**
 * 目标和
 */
public class xie7_494 {
    public static void main(String[] args) {
        // 整数数组nums 整数target 在每个整数前添加+或者-，使得表达式和为target
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(nums, target));
    }

    public static int solution(int[] nums, int target) {
        // 所有正数和为sP, 所有负数和为sN
        // 有：sP+sN = tgarget, sP-sN=sum_nums
        // sP = target + sum_nums / 2
        // 转换01背包问题，从nums数组中选择元素填充sP背包
        int sum = 0;
        for (int num :
                nums) {
            sum += num;
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int sP = (target + sum) / 2;
        int len = nums.length;
        int[] dp = new int[sP + 1];
        dp[0] = 1;

        for (int num :
                nums) {
            for (int i = sP; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[sP];
    }
}
