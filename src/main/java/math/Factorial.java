package math;

public class Factorial {

	public static void fact(int x) {

		for (int i = (x - 1); i > 1; i--) {
			x = x * i;
		}

		System.out.println("Factorial of a number is " + x);
	}

	public static void main(String s[]) {
		fact(5);
	}
}
