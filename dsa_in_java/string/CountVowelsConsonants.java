/*
 * Topic: Count Vowels and Consonants
 * Language: Java
 *
 * Description:
 * Given a string, count the number of vowels and consonants in it.
 *
 * Example:
 * Input: "hello world"
 * Output:
 * Vowels: 3
 * Consonants: 7
 */

public class CountVowelsConsonants {

    /**
     * Counts vowels and consonants in the given string.
     * @param s The input string.
     */
    public static void count(String s) {
        int vowels = 0, consonants = 0;
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        String input = "hello world";
        count(input);
    }
}

/*
 * ----------------------------------------------
 * Example Output:
 * Vowels: 3
 * Consonants: 7
 * ----------------------------------------------
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
