/*
 * Topic: Minimum Path Sum
 * Language: Java
 *
 * Description:
 * Given a grid filled with non-negative numbers, find a path from top-left to bottom-right
 * which minimizes the sum of all numbers along its path.
 * You can only move right or down.
 *
 * Example:
 * Input: [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 */

public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1,3,1},
            {1,5,1},
            {4,2,1}
        };
        System.out.println("Min Path Sum: " + minPathSum(grid));
    }
}

/*
 * Output:
 * Min Path Sum: 7
 *
 * Time: O(m*n)
 * Space: O(1)
 * LeetCode: https://leetcode.com/problems/minimum-path-sum/
 */
