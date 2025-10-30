/*
 * Topic: Two Sum using HashMap
 * Language: Java
 *
 * Description:
 * Given an array of integers `nums` and an integer `target`,
 * return indices of the two numbers such that they add up to `target`.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 *
 * Explanation:
 * nums[0] + nums[1] = 2 + 7 = 9
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // No solution found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] res = twoSum(nums, target);
        System.out.println("Indices: [" + res[0] + ", " + res[1] + "]");
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Indices: [0, 1]
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Concept Used:
 * - HashMap for O(1) complement lookup
 */
