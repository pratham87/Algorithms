package dynamicProgramming;

public class LongestPalindromicSubsequence {

	public static int lps(String s) {
		int[][] demo = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			demo[i][i] = 1;
		}

		for (int l = 2; l <= s.length(); l++) {
			for (int i = 0; i < s.length() - l + 1; i++) {
				int j = i + l - 1;
				if (l == 2 && s.charAt(i) == s.charAt(j)) {
					demo[i][j] = 2;
				} else if (s.charAt(i) == s.charAt(j)) {
					demo[i][j] = 2 + demo[i + 1][j - 1];
				} else {
					demo[i][j] = Math.max(demo[i + 1][j], demo[i][j - 1]);
				}
			}
		}

		return demo[0][s.length() - 1];
	}

	public static void main(String[] args) {
		String s = "agbdba";
		System.out.println("The length of the lps is " + lps(s));
	}

}
