/*
 * Topic: Subarray Sum Equals K
 * Language: Java
 *
 * Description:
 * Given an array of integers `nums` and an integer `k`,
 * return the total number of subarrays whose sum equals to `k`.
 *
 * Example:
 * Input: nums = [1, 1, 1], k = 2
 * Output: 2
 *
 * Explanation:
 * Subarrays [1,1] (indices 0–1) and [1,1] (indices 1–2) sum to 2.
 */

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("Subarray count: " + subarraySum(nums, k));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Subarray count: 2
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Concept Used:
 * - Prefix sum technique + HashMap for quick lookup.
 */
