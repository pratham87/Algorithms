package dynamicProgramming;

/*
 Algorithm:Pair chars of str2 with str1 (increasing window of length for both). Refer the memo matrix.
 1. If same char then 1 + memo[i-1][j-1]
 */

public class LongestCommonSubstring {

	public static int lcs(String s1, String s2) {
		int[][] memo = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					memo[i][j] = 1 + memo[i - 1][j - 1];
				}
				if (memo[i][j] > max) {
					max = memo[i][j];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lcs("abcdaf", "zbcdf"));
	}

}
