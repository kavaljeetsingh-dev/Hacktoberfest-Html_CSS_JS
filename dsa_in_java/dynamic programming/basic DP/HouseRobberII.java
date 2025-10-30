/*
 * Topic: House Robber II
 * Language: Java
 *
 * Description:
 * Houses form a circle. You cannot rob adjacent houses.
 * Solve by splitting into two linear subproblems.
 */

public class HouseRobberII {

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    private static int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2};
        System.out.println("Max amount (circular): " + rob(nums));
    }
}

/*
 * Output: Max amount (circular): 3
 * Time: O(n), Space: O(1)
 * LeetCode: https://leetcode.com/problems/house-robber-ii/
 */
