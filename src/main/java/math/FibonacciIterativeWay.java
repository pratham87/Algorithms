package math;

public class FibonacciIterativeWay {

	//O(n)
	public static int fibo(int n) {
		int[] sequence = new int[n];

		sequence[0] = 1;
		sequence[1] = 1;

		for (int i = 2; i < sequence.length; i++) {
			sequence[i] = sequence[i - 1] + sequence[i - 2];
		}

		return sequence[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(fibo(6));
	}

}
