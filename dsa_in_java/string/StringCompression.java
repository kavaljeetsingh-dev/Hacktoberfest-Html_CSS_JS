/*
 * Topic: String Compression
 * Language: Java
 *
 * Description:
 * Given an array of characters, compress it in-place using the counts of repeated characters.
 *
 * Example:
 * Input: ['a','a','b','b','c','c','c']
 * Output: 6 → ["a","2","b","2","c","3"]
 *
 * LeetCode Link: https://leetcode.com/problems/string-compression/
 */

public class StringCompression {

    /**
     * Compresses a string by replacing consecutive characters with their counts.
     * @param chars The character array.
     * @return The new length after compression.
     */
    public static int compress(char[] chars) {
        int index = 0, i = 0;

        while (i < chars.length) {
            char curr = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == curr) {
                i++;
                count++;
            }

            chars[index++] = curr;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        char[] input = {'a','a','b','b','c','c','c'};
        int newLen = compress(input);
        System.out.print("Compressed String: ");
        for (int i = 0; i < newLen; i++) System.out.print(input[i]);
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Compressed String: a2b2c3
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
