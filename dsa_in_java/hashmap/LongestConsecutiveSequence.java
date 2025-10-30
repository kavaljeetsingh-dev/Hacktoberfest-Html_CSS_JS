/*
 * Topic: Longest Consecutive Sequence
 * Language: Java
 *
 * Description:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 *
 * Explanation:
 * The longest consecutive elements sequence is [1, 2, 3, 4].
 */

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) { // start of a sequence
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence: " + longestConsecutive(nums));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Longest Consecutive Sequence: 4
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Concept Used:
 * - HashSet to track sequence continuity.
 */
