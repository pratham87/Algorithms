package dynamicProgramming;

/*
Algorithm: Window of increasing length
1. l = 2: 2 char window and so on.  
2. If extreme end chars are same then 2 + max(lps(middle string))
   else max(precomputed lps)
*/

public class LongestPalindromicSubsequence {

	public static int lps(String s) {
		int[][] memo = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			memo[i][i] = 1;
		}

		for (int l = 2; l <= s.length(); l++) {
			for (int i = 0; i < s.length() - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2 && s.charAt(i) == s.charAt(j)) {
					memo[i][j] = 2;
				} else if (s.charAt(i) == s.charAt(j)) {
					memo[i][j] = 2 + memo[i + 1][j - 1];
				} else {
					memo[i][j] = Math.max(memo[i + 1][j], memo[i][j - 1]);
				}
			}
		}

		return memo[0][s.length() - 1];
	}

	public static void main(String[] args) {
		String s = "agbdba";
		System.out.println("The length of the lps is " + lps(s));
	}

}
