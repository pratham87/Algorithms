package math;

/*
 Time Complexity: O(n)
 Space Complexity: O(1)
  
 */

public class ReverseNumber {

	public static int reverseNumber(int x) {
		long n = 0;
		while (x != 0) {
			n = n * 10 + x % 10;
			x = x / 10;
		}

		return Math.abs(n) > Integer.MAX_VALUE ? 0 : (int) n;

	}

	public static void main(String[] args) {

		int number = -1234;

		System.out.println("Reversed Number is: " + reverseNumber(number));

	}
}
