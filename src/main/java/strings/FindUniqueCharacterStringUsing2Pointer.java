package strings;

public class FindUniqueCharacterStringUsing2Pointer {

	public static boolean unique(String str) {
		int i = 0;

		while (i < str.length() - 1) {
			int j = str.length() - 1;
			while (i < j) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				} else {
					j--;
				}
			}
			i++;
		}

		return true;
	}

	public static void main(String[] args) {

		String str = "abB";

		System.out.println(unique(str));

	}

}
