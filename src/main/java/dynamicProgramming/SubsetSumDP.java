package dynamicProgramming;

/*
 Question: Find out if there exist a sub­set in array whose sum is equal to given sum S.
 
  Algorithm:
  1. Using DP, add 0th row and column to the demo matrix.
  2. True if top value is true or (j - nums[i]) (ie; diff) is achieved in the previous row.
     else false 
 */

public class SubsetSumDP {

	public static boolean subsetSum(int[] nums, int sum) {
		// Default values are all False
		boolean[][] memo = new boolean[nums.length + 1][sum + 1];

		for (int i = 0; i < memo.length; i++) {
			memo[i][0] = true;
		}

		for (int i = 1; i < memo.length; i++) {
			for (int j = 1; j < memo[0].length; j++) {
				if (j - nums[i - 1] == 0) {
					memo[i][j] = true;
				} else if (j - nums[i - 1] > 0) {
					memo[i][j] = memo[i - 1][j] || memo[i - 1][j - nums[i - 1]];
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		return memo[nums.length][sum];
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 7, 1 };
		System.out.println(subsetSum(nums, 6));
	}

}
