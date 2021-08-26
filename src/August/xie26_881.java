package August;

import java.util.Arrays;

/**
 * 救生艇
 */

public class xie26_881 {
    /**
     * 第i个人的体重为people[i]，每艘船可以承载的最大重量为limit。
     * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为limit。
     * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
     */
    public static void main(String[] args) {
        int[] people = new int[]{3, 3, 5, 4};
        int limit = 5;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int ans = 0;
        while (l <= r) {
            if (people[l] + people[r] > limit) r--;
            else {
                r--;
                l++;
            }
            ans++;
        }
        return ans;
    }
}
