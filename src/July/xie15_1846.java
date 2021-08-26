package July;

import java.util.Arrays;

/**
 * 减小和重新排列数组后的最大元素
 */
public class xie15_1846 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 1, 2, 1};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) arr[i] = arr[i - 1] + 1;
        }
        return arr[len - 1];
    }
}
