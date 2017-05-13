package strings;

public class SumOfNumbersInStringUsingSplit {

	public static int sum(String s) {
		int sum = 0;
		String[] tokens = s.split("[a-z]+");

		for (int i = 0; i < tokens.length; i++) {
			System.out.print(tokens[i] + " ");
		}

		for (int i = 1; i < tokens.length; i++) {
			sum = sum + Integer.parseInt(tokens[i]);
		}
		return sum;
	}

	public static void main(String[] s) {
		System.out.println("\nSum is: " + sum("abc1xy2mno78jh3khl21"));

	}

}
