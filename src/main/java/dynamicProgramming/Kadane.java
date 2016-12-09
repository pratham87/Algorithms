package dynamicProgramming;

public class Kadane {

	public static void main(String[] args) {
		int[] numbers = { -2, -1, 0, 3, -4, -5 };
		findMaxSubArray(numbers);

	}

	public static void findMaxSubArray(int[] numbers) {
		int max_so_far = 0;
		int max_ending_here = 0;
		for (int x : numbers) {
			max_ending_here = Math.max(0, max_ending_here + x);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		System.out.println(max_so_far);
	}
}
