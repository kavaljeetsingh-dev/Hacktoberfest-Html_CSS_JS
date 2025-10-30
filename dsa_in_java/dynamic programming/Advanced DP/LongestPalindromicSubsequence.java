/*
 * Topic: Longest Palindromic Subsequence
 * Language: Java
 *
 * Description:
 * Find the longest palindromic subsequence in a string.
 *
 * Example:
 * Input: "bbbab"
 * Output: 4 ("bbbb")
 */

public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println("Longest Palindromic Subsequence: " + longestPalindromeSubseq("bbbab"));
    }
}

/*
 * Output:
 * Longest Palindromic Subsequence: 4
 *
 * Time: O(n^2)
 * Space: O(n^2)
 * LeetCode: https://leetcode.com/problems/longest-palindromic-subsequence/
 */
