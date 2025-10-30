/*
 * Topic: Partition Equal Subset Sum
 * Language: Java
 *
 * Description:
 * Determine if the array can be partitioned into two subsets
 * with equal sum.
 *
 * Example:
 * Input: [1,5,11,5]
 * Output: true
 */

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums)
            for (int j = target; j >= num; j--)
                dp[j] = dp[j] || dp[j - num];

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println("Can Partition: " + canPartition(nums));
    }
}

/*
 * Output:
 * Can Partition: true
 *
 * Time: O(n*sum)
 * Space: O(sum)
 * LeetCode: https://leetcode.com/problems/partition-equal-subset-sum/
 */
