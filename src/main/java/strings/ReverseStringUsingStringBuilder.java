package strings;

//Same program can be used to find if the given String is palindrome or not.
public class ReverseStringUsingStringBuilder {
	public static void main(String[] args) {
		String input = "Hello there";

		System.out.println(new StringBuilder(input).reverse().toString());

	}
}
