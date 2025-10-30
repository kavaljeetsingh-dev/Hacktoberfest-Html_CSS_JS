/*
 * Topic: Coin Change II
 * Language: Java
 *
 * Description:
 * Count the number of combinations that make up the amount.
 * You can use each coin unlimited times.
 *
 * Example:
 * Input: coins = [1,2,5], amount = 5
 * Output: 4
 * Explanation: [5], [2,2,1], [2,1,1,1], [1,1,1,1,1]
 */

public class CoinChangeII {

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] += dp[i - coin];

        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println("Combinations: " + change(amount, coins));
    }
}

/*
 * Output:
 * Combinations: 4
 *
 * Time: O(n*amount)
 * Space: O(amount)
 * LeetCode: https://leetcode.com/problems/coin-change-ii/
 */
