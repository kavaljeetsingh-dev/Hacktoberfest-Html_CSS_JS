/*
 * Topic: Valid Parentheses
 * Language: Java
 *
 * Description:
 * Given a string containing only '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * Example:
 * Input: "()[]{}"
 * Output: true
 *
 * Explanation:
 * Every open bracket must be closed in the correct order.
 *
 * LeetCode Link: https://leetcode.com/problems/valid-parentheses/
 */

import java.util.Stack;

public class ValidParentheses {

    /**
     * Checks if the parentheses string is valid.
     * @param s The input string.
     * @return true if valid, false otherwise.
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "{[()]}";
        System.out.println("Is Valid: " + isValid(input));
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Is Valid: true
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
