package strings;

public class ReverseStringUsingTwoPointerTechnique {

	public static String reverse(String s) {
		char[] array = s.replaceAll("\\s", "").toCharArray();
		int i = 0, j = array.length - 1;

		while (i < j) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
			i++;
			j--;
		}

		return String.valueOf(array);
	}

	public static void main(String[] args) {

		System.out.println(reverse("hello there"));

	}

}
