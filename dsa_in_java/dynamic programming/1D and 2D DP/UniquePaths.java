/*
 * Topic: Unique Paths
 * Language: Java
 *
 * Description:
 * A robot is located at the top-left corner of an m x n grid.
 * It can move only down or right at any point in time.
 * Find the number of possible unique paths to reach the bottom-right corner.
 *
 * Example:
 * Input: m = 3, n = 7
 * Output: 28
 */

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Fill the first row and first column with 1
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;

        // Fill the DP table
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println("Unique Paths: " + uniquePaths(m, n));
    }
}

/*
 * Output:
 * Unique Paths: 28
 *
 * Time: O(m*n)
 * Space: O(m*n)
 * LeetCode: https://leetcode.com/problems/unique-paths/
 */
