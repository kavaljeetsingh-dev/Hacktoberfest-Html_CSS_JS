/*
 * Topic: Min Cost Climbing Stairs
 * Language: Java
 *
 * Description:
 * You can climb either 1 or 2 steps. Each step has a cost.
 * Return the minimum cost to reach the top.
 *
 * Example:
 * Input: cost = [10,15,20]
 * Output: 15
 */

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++)
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("Min cost: " + minCostClimbingStairs(cost));
    }
}

/*
 * Output: Min cost: 15
 * Time: O(n), Space: O(n)
 * LeetCode: https://leetcode.com/problems/min-cost-climbing-stairs/
 */
