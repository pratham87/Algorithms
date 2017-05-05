package strings;

import java.util.HashSet;
import java.util.Set;

//Two Pointer technique
public class ReverseVowelsInAString {

	public static String reverseVowels(String s) {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');

		char[] array = s.toCharArray();
		int i = 0, j = array.length - 1;

		while (i < j) {
			if (set.contains(array[i]) && set.contains(array[j])) {
				char temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
			if (!set.contains(array[i])) {
				i++;
			} else if (!set.contains(array[j])) {
				j--;
			}
		}

		return String.valueOf(array);

	}

	public static void main(String[] args) {

		String s = "hello";

		System.out.println(reverseVowels(s));
	}

}
