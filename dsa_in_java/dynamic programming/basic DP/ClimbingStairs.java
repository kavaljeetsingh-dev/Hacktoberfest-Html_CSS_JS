/*
 * Topic: Climbing Stairs
 * Language: Java
 *
 * Description:
 * You are climbing a staircase with n steps.
 * You can climb 1 or 2 steps at a time.
 * Find how many distinct ways to reach the top.
 *
 * Example:
 * Input: n = 3
 * Output: 3
 * Explanation: (1+1+1), (1+2), (2+1)
 */

public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Distinct ways: " + climbStairs(n));
    }
}

/*
 * Output:
 * Distinct ways: 8
 * Time: O(n), Space: O(n)
 * LeetCode: https://leetcode.com/problems/climbing-stairs/
 */
