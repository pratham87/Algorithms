package dynamicProgramming;

public class LongestCommonSubsequence {

	public static int lcs(String s1, String s2) {
		int[][] demo = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;

		for (int i = 1; i < demo.length; i++) {
			for (int j = 1; j < demo.length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					demo[i][j] = demo[i - 1][j - 1] + 1;
				} else {
					demo[i][j] = Math.max(demo[i - 1][j], demo[i][j - 1]);
				}

				if (demo[i][j] > max) {
					max = demo[i][j];
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(lcs("abcaf", "acbcf"));

	}

}
