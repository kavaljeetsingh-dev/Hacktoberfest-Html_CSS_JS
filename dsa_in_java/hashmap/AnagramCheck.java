/*
 * Topic: Check if Two Strings are Anagrams
 * Language: Java
 *
 * Description:
 * Given two strings `s` and `t`, return true if `t` is an anagram of `s`, and false otherwise.
 * 
 * An Anagram is a word formed by rearranging the letters of another.
 *
 * Example:
 * Input: s = "listen", t = "silent"
 * Output: true
 *
 * Explanation:
 * Both have the same character counts for all letters.
 */

import java.util.HashMap;

public class AnagramCheck {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0)
                map.remove(c);
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listen", "silent")); // true
        System.out.println(isAnagram("hello", "world"));   // false
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * true
 * false
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) — limited to alphabet size
 *
 * Concept Used:
 * - HashMap for frequency comparison
 */
