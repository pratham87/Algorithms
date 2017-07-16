package math;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrimeNumberUsingStream {

	private static boolean isPrime(int number) {
		IntPredicate isDivisible = x -> number % x == 0;
		return number > 1 && IntStream.range(2, number - 1).noneMatch(isDivisible);
	}

	public static void main(String[] args) {
		System.out.println(isPrime(23));
	}

}
