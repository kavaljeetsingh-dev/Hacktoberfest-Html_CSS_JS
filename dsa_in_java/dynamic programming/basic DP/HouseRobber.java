/*
 * Topic: House Robber
 * Language: Java
 *
 * Description:
 * You cannot rob two adjacent houses.
 * Find the maximum amount of money you can rob.
 *
 * Example:
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob houses 2 and 9 = 12
 */

public class HouseRobber {

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println("Max amount: " + rob(nums));
    }
}

/*
 * Output: Max amount: 12
 * Time: O(n), Space: O(n)
 * LeetCode: https://leetcode.com/problems/house-robber/
 */
