/*
 * Topic: Longest Substring Without Repeating Characters
 * Language: Java
 *
 * Description:
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with length 3.
 *
 * LeetCode Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

import java.util.HashSet;

public class LongestSubstringNoRepeat {

    /**
     * Finds the length of the longest substring without repeating characters.
     * @param s The input string.
     * @return Length of the longest substring.
     */
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Length of Longest Substring: " + lengthOfLongestSubstring(input));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Length of Longest Substring: 3
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
