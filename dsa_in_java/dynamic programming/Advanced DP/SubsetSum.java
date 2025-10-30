/*
 * Topic: Subset Sum Problem
 * Language: Java
 *
 * Description:
 * Given an array of non-negative integers and a sum,
 * determine if there exists a subset with a given sum.
 *
 * Example:
 * Input: nums = [3, 34, 4, 12, 5, 2], sum = 9
 * Output: true (subset [4,5] or [3,2,4])
 */

public class SubsetSum {

    public static boolean isSubsetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println("Subset exists: " + isSubsetSum(nums, sum));
    }
}

/*
 * Output:
 * Subset exists: true
 *
 * Time: O(n*sum)
 * Space: O(n*sum)
 * LeetCode: https://leetcode.com/problems/partition-equal-subset-sum/
 */
