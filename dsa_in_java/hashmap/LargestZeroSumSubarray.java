/*
 * Topic: Largest Subarray with Zero Sum
 * Language: Java
 *
 * Description:
 * Given an array, find the length of the largest subarray with sum = 0.
 *
 * Example:
 * Input: [15, -2, 2, -8, 1, 7, 10, 23]
 * Output: 5
 *
 * Explanation:
 * Subarray [-2, 2, -8, 1, 7] sums to 0.
 */

import java.util.HashMap;

public class LargestZeroSumSubarray {
    public static int maxLen(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0)
                maxLen = i + 1;

            if (map.containsKey(sum))
                maxLen = Math.max(maxLen, i - map.get(sum));
            else
                map.put(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Max Length of Zero Sum Subarray: " + maxLen(arr));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Max Length of Zero Sum Subarray: 5
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Concept Used:
 * - Prefix sum + HashMap for first occurrence tracking.
 */
