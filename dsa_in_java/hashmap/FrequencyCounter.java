/*
 * Topic: Count Frequency of Each Element
 * Language: Java
 *
 * Description:
 * Given an array of integers, count the frequency of each element using a HashMap.
 *
 * Example:
 * Input: arr = [1, 2, 2, 3, 3, 3]
 * Output:
 * 1 -> 1
 * 2 -> 2
 * 3 -> 3
 */

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3};
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
            System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * 1 -> 1
 * 2 -> 2
 * 3 -> 3
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Concept Used:
 * - HashMap for frequency mapping
 */
