package strings;

public class FindUniqueCharacterStringUsingASCIIcode {

	public static boolean unique(String str) {
		boolean[] charSet = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charSet[val]) {
				return false;
			}
			charSet[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "abB";

		System.out.println(unique(str));

	}

}
