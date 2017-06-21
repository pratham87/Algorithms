package strings;

import java.util.HashSet;
import java.util.Set;

/*
 Given a string, find the length of the longest substring without repeating characters. 
 For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 For "bbbbb" the longest substring is "b", with the length of 1.
 
 Algorithm:
 
 1. Use HashSet to track repeating chars.
 2. Add every char to set and calculate the MAX length.
 3. If Set already has that char, clear the set and repeat the same process.
  
 */

public class LongestSubstringLength {

	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (set.add(s.charAt(i))) {
				max = Math.max(max, set.size());
			} else {
				set.clear();
				set.add(s.charAt(i));
			}
		}

		return max;
	}

	public static void main(String[] args) {

		System.out.println(lengthOfLongestSubstring("abcabcdab"));
	}

}
