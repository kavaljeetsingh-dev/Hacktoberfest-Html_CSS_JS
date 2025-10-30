/*
 * Topic: Palindrome String
 * Language: Java
 *
 * Description:
 * Determine if a given string is a palindrome (reads the same backward as forward).
 *
 * Example:
 * Input: "madam"
 * Output: true
 *
 * Explanation:
 * 'madam' reversed is also 'madam'.
 */

public class PalindromeString {

    /**
     * Checks if the given string is a palindrome.
     * @param s The input string.
     * @return true if palindrome, false otherwise.
     */
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "madam";
        System.out.println("Is Palindrome: " + isPalindrome(input));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Is Palindrome: true
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
