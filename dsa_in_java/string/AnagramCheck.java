/*
 * Topic: Check if Two Strings are Anagrams
 * Language: Java
 *
 * Description:
 * Two strings are anagrams if they contain the same characters in any order.
 *
 * Example:
 * Input: "listen", "silent"
 * Output: true
 *
 * Explanation:
 * Both strings contain the same letters with the same frequency.
 *
 * LeetCode Link: https://leetcode.com/problems/valid-anagram/
 */

import java.util.Arrays;

public class AnagramCheck {

    /**
     * Checks if two strings are anagrams.
     * @param s First string.
     * @param t Second string.
     * @return true if anagrams, false otherwise.
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String s1 = "listen", s2 = "silent";
        System.out.println("Are Anagrams: " + isAnagram(s1, s2));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Are Anagrams: true
 * ----------------------------------------------
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
