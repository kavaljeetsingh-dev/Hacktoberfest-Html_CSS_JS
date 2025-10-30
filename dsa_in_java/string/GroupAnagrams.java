/*
 * Topic: Group Anagrams
 * Language: Java
 *
 * Description:
 * Given an array of strings, group the anagrams together.
 *
 * Example:
 * Input: ["eat","tea","tan","ate","nat","bat"]
 * Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
 *
 * LeetCode Link: https://leetcode.com/problems/group-anagrams/
 */

import java.util.*;

public class GroupAnagrams {

    /**
     * Groups words that are anagrams of each other.
     * @param strs Array of input strings.
     * @return List of grouped anagrams.
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * [[eat, tea, ate], [tan, nat], [bat]]
 * ----------------------------------------------
 *
 * Time Complexity: O(n * k log k)
 * Space Complexity: O(n)
 */
