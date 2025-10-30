/*
 * Topic: Reverse a String
 * Language: Java
 *
 * Description:
 * Write a program to reverse a given string without using built-in reverse functions.
 *
 * Example:
 * Input: "hello"
 * Output: "olleh"
 *
 * Explanation:
 * Reverse the characters one by one from end to start.
 */

public class ReverseString {

    /**
     * Reverses the given string.
     * @param s The input string.
     * @return The reversed string.
     */
    public static String reverse(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reverse(input));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Original: hello
 * Reversed: olleh
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
