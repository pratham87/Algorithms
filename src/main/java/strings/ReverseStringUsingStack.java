package strings;

import java.util.Stack;

public class ReverseStringUsingStack {

	public static void main(String s[]) {
		String word = "Hello there";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < word.length(); i++) {
			stack.push(word.charAt(i));
		}

		StringBuilder reverseWord = new StringBuilder();

		while (!stack.isEmpty()) {
			reverseWord.append(stack.pop());
		}

		System.out.println(reverseWord);
	}
}
