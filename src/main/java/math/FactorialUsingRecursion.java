package math;

public class FactorialUsingRecursion {

	public static int fact(int x) {
		if (x <= 1)
			return 1;
		else
			return x * fact(x - 1);
	}

	public static void main(String s[]) {
		System.out.println("Factorial of number using recursion: " + fact(3));
	}
}


/** Working
 
fact(3) = 3 * fact(2)
fact(2) = 2 * 1

*/

