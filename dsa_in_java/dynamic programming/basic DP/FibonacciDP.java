/*
 * Topic: Fibonacci Number (Top-down & Bottom-up)
 * Language: Java
 *
 * Description:
 * Compute the nth Fibonacci number using both
 * - Top-down (Recursion + Memoization)
 * - Bottom-up (Tabulation)
 *
 * Example:
 * Input: n = 6
 * Output: 8
 *
 * Explanation:
 * Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8
 * F(6) = 8
 */

import java.util.*;

public class FibonacciDP {

    // Top-down approach (Memoization)
    public static int fibTopDown(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        dp[n] = fibTopDown(n - 1, dp) + fibTopDown(n - 2, dp);
        return dp[n];
    }

    // Bottom-up approach (Tabulation)
    public static int fibBottomUp(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Top-down: " + fibTopDown(n, dp));
        System.out.println("Bottom-up: " + fibBottomUp(n));
    }
}

/*
 * Output:
 * Top-down: 8
 * Bottom-up: 8
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * LeetCode: https://leetcode.com/problems/fibonacci-number/
 */
