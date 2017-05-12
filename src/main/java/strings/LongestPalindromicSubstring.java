package strings;

/*
 Algorithm: Expanding the Window OR Spreading outwards from a given position
 1. Point two pointers at every char in the string.
 2. Spread those pointers outwards until s.charAt(j) != s.charAt(k).
 3. Then calculate maxLen.
 4. Once we have maxLen, point start to the beginning of the palindromic substring.
 5. That way, everytime we update maxLen, start will be updated as well - Line 33. 
 */

public class LongestPalindromicSubstring {

	private static int start, maxLen;

	public static String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2) {
			return s;
		}

		for (int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i); // Odd length palindrome.
			extendPalindrome(s, i, i + 1); // Even length palindrome.
		}
		return s.substring(start, start + maxLen);
	}

	private static void extendPalindrome(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			start = j + 1;
			maxLen = k - j - 1;
		}
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("sabbaq"));
	}

}
