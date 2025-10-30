/*
 * Topic: Group Anagrams
 * Language: Java
 *
 * Description:
 * Given an array of strings `strs`, group the anagrams together.
 *
 * Example:
 * Input: ["eat","tea","tan","ate","nat","bat"]
 * Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
 *
 * Explanation:
 * Words with same sorted character sequence belong to same group.
 */

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * [[eat, tea, ate], [tan, nat], [bat]]
 * ----------------------------------------------
 *
 * Time Complexity: O(n * k log k)
 * Space Complexity: O(n * k)
 *
 * Concept Used:
 * - HashMap groups words by sorted key string.
 */
