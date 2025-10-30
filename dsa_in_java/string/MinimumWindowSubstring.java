/*
 * Topic: Minimum Window Substring
 * Language: Java
 *
 * Description:
 * Given two strings s and t, find the minimum window in s that contains all characters of t.
 *
 * Example:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 *
 * LeetCode Link: https://leetcode.com/problems/minimum-window-substring/
 */

import java.util.HashMap;

public class MinimumWindowSubstring {

    /**
     * Finds the minimum window substring containing all characters of t in s.
     * @param s The source string.
     * @param t The target string.
     * @return The smallest window containing all chars of t.
     */
    public static String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, count = t.length(), start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            if (map.containsKey(r)) {
                if (map.get(r) > 0) count--;
                map.put(r, map.get(r) - 1);
            }
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                if (map.containsKey(l)) {
                    map.put(l, map.get(l) + 1);
                    if (map.get(l) > 0) count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum Window Substring: " + minWindow(s, t));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Minimum Window Substring: BANC
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
