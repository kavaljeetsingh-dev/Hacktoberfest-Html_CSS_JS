/*
 * Topic: Longest Common Prefix
 * Language: Java
 *
 * Description:
 * Find the longest common prefix among an array of strings.
 *
 * Example:
 * Input: ["flower", "flow", "flight"]
 * Output: "fl"
 *
 * LeetCode Link: https://leetcode.com/problems/longest-common-prefix/
 */

public class LongestCommonPrefix {

    /**
     * Finds the longest common prefix among strings.
     * @param strs Array of strings.
     * @return The longest common prefix.
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] words = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(words));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Longest Common Prefix: fl
 * ----------------------------------------------
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */
