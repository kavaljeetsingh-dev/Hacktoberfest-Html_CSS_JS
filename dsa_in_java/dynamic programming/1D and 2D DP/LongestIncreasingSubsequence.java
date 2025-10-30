/*
 * Topic: Longest Increasing Subsequence (LIS)
 * Language: Java
 *
 * Description:
 * Find the length of the longest increasing subsequence in an array.
 *
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 (The LIS is [2,3,7,101])
 */

import java.util.*;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);

        for (int val : dp) max = Math.max(max, val);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println("LIS Length: " + lengthOfLIS(nums));
    }
}

/*
 * Output:
 * LIS Length: 4
 *
 * Time: O(n^2)
 * Space: O(n)
 * LeetCode: https://leetcode.com/problems/longest-increasing-subsequence/
 */
