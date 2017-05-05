package strings;

/**
 * Write a program for String abbreviation by replacing all the characters in
 * between the first and last character by the number count of characters in
 * between like hello should be h3o(replace ell 3 characters by 3)
 **/
public class ReplaceSubstring {

	public static StringBuilder getCount(String s) {
		StringBuilder str = new StringBuilder(s);

		return str.replace(1, str.length() - 1, Integer.toString(str.length() - 2));
	}

	public static void main(String[] args) {

		System.out.println(getCount("hello"));
	}

}
