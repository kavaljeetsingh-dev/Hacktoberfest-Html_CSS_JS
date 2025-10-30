/*
 * Topic: Coin Change
 * Language: Java
 *
 * Description:
 * You are given coins of different denominations and an amount.
 * Find the fewest number of coins needed to make up that amount.
 *
 * Example:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3 (11 = 5 + 5 + 1)
 */

import java.util.*;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Fewest coins: " + coinChange(coins, amount));
    }
}

/*
 * Output:
 * Fewest coins: 3
 *
 * Time: O(n*amount)
 * Space: O(amount)
 * LeetCode: https://leetcode.com/problems/coin-change/
 */
