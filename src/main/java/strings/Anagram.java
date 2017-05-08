package strings;

import java.util.Arrays;

/*
 Algorithm:
 
 1. Replace all spaces and convert to char[]
 2. Sort both words 
 3. Compare them
 */

public class Anagram {

	public static boolean isAnagram(String firstWord, String secondWord) {
		char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
		char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
		Arrays.sort(word1);
		Arrays.sort(word2);
		return Arrays.equals(word1, word2);
	}

	public static void main(String s[]) {
		System.out.println(isAnagram("hello there", "hello there"));
	}

}
