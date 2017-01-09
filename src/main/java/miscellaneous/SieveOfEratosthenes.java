package miscellaneous;

//Implemented using two pointer technique
public class SieveOfEratosthenes {

	static boolean prime[];

	public static void sieveOfEratosthenes(int n) {

		prime = new boolean[n + 1];

		// Initialize boolean array
		for (int i = 0; i < n; i++) {
			prime[i] = true;
		}

		// Mark out non prime numbers
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (prime[i] == true) {
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;
			}
		}
	}

	public static void printNumbers(int n) {
		for (int i = 2; i <= n; i++) {
			if (prime[i] == true) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String args[]) {
		int n = 30;
		System.out.println("Prime numbers in the range of " + n);
		sieveOfEratosthenes(n);
		printNumbers(n);
	}
}