/*
 * Topic: 0/1 Knapsack Problem
 * Language: Java
 *
 * Description:
 * Given weights and values of n items, put these items in a knapsack of capacity W
 * to get the maximum total value in the knapsack.
 * Each item can be included at most once.
 *
 * Example:
 * Input: values = [60, 100, 120], weights = [10, 20, 30], W = 50
 * Output: 220
 * Explanation: Choose items with weight 20 and 30 → total value = 220
 */

public class Knapsack01 {

    public static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        System.out.println("Max Value: " + knapSack(W, wt, val, val.length));
    }
}

/*
 * Output:
 * Max Value: 220
 *
 * Time: O(n*W)
 * Space: O(n*W)
 * LeetCode: https://leetcode.com/problems/knapsack-problem/
 */
