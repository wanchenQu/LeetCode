package July;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 错误的集合
 */
public class xie4_645 {
    /**
     * 集合 s 包含从 1 到n的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
     * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
     * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }

    public static int[] findErrorNums(int[] nums) {
        int len = nums.length;
        //Set<Integer> set = new HashSet<>();
        int[] set = new int[len + 1];
        int s0 = (1 + len) * len / 2, s1 = 0, s2 = 0;
        for (int a : nums) {
            if (set[a] == 0) {
                s2 += a;
                //set.add(a);
                set[a] = 1;
            }
            s1 += a;
        }
        return new int[]{s1 - s2, s0 - s2};
    }
}
