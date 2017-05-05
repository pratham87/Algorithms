package strings;

/*
 * Write a function to find a substring in a string.
 */
public class FindSubString {

	public static void main(String[] args) {
		String s1 = "This is a example string";
		String s2 = "example";

		System.out.println(usingContains(s1, s2));
		System.out.println(usingIndexOf(s1, s2));
		System.out.println(findSubString(s1, s2));

	}

	public static boolean usingContains(String s1, String s2) {
		if (s1.replaceAll("\\s", "").toLowerCase().contains(s2.toLowerCase())) {
			return true;
		}
		return false;
	}

	public static boolean usingIndexOf(String s1, String s2) {
		if (s1.indexOf(s2) != -1) {
			return true;
		}
		return false;
	}

	public static boolean findSubString(String sentence, String word) {
		boolean found = false;
		int max = sentence.length() - word.length();

		checkrecusion: for (int i = 0; i <= max; i++) {
			int n = word.length();

			int j = i;
			int k = 0;

			while (n-- != 0) {
				if (sentence.charAt(j++) != word.charAt(k++)) {
					continue checkrecusion;
				}
			}
			found = true;
			break checkrecusion;
		}
		return found;
	}

}
