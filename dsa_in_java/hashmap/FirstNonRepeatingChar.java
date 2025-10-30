/*
 * Topic: Find First Non-Repeating Character in a String
 * Language: Java
 *
 * Description:
 * Given a string `s`, find the first character that does not repeat.
 * Use a HashMap to count the frequency of each character efficiently.
 *
 * If there is no non-repeating character, return '_'.
 *
 * Example:
 * Input:  s = "swiss"
 * Output: 'w'
 *
 * Explanation:
 * Character frequencies:
 * s → 3 times
 * w → 1 time
 * i → 1 time
 *
 * The first non-repeating character is 'w'.
 */

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    
    /**
     * Finds the first non-repeating character in the given string.
     * @param s Input string
     * @return The first unique character, or '_' if none exists.
     */
    public static char firstUniqueChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Find first character with frequency 1
        for (char c : s.toCharArray()) {
            if (freq.get(c) == 1)
                return c;
        }

        return '_';
    }

    public static void main(String[] args) {
        String s1 = "swiss";
        String s2 = "aabb";
        String s3 = "leetcode";

        System.out.println("Input: " + s1 + " → Output: " + firstUniqueChar(s1));
        System.out.println("Input: " + s2 + " → Output: " + firstUniqueChar(s2));
        System.out.println("Input: " + s3 + " → Output: " + firstUniqueChar(s3));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 *
 * Input: swiss → Output: w
 * Input: aabb → Output: _
 * Input: leetcode → Output: l
 * ----------------------------------------------
 *
 * Time Complexity:
 * - O(n) — where n is the length of the string (two passes)
 *
 * Space Complexity:
 * - O(1) — at most 26 (or limited by unique characters)
 *
 * Concepts Used:
 * - HashMap for frequency counting
 * - Iteration to find the first unique occurrence
 */
