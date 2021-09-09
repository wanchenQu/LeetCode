package September;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最小K个数
 */

public class xie3_M17_14 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        System.out.println(Arrays.toString(smallestK(arr, k)));
    }

    public static int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int i : arr) q.add(i);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = q.poll();
        return ans;
    }

}
