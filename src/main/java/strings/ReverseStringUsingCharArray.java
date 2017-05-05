package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Same program can be used to find if the given String is palindrome or not.
public class ReverseStringUsingCharArray {
	public static void main(String[] args) {
		String input = "";
		System.out.println("Enter the input string");
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = br.readLine();
			char[] try1 = input.toCharArray();
			for (int i = try1.length - 1; i >= 0; i--)
				System.out.print(try1[i]);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}