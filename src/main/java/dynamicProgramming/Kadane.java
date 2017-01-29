package dynamicProgramming;

public class Kadane {

	// Works only if there is atleast one positive element
	public static int kadane(int[] numbers) {
		int max_end_here = 0;
		int max_so_far = 0;
		for (int i = 0; i < numbers.length; i++) {
			max_end_here += numbers[i];
			if (max_end_here < 0) {
				max_end_here = 0;
			}
			if (max_so_far < max_end_here) {
				max_so_far = max_end_here;
			}
		}
		System.out.println(max_so_far);
		return max_so_far;
	}

	// For all negative elements in an array
	public static void kadaneModified(int[] numbers) {
		int max_so_far = 0;
		int max_ending_here = 0;
		for (int x : numbers) {
			max_ending_here = Math.max(0, max_ending_here + x);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		System.out.println(max_so_far);
	}

	public static void main(String[] args) {
		int[] numbers = { -2, -1, 3, 4, -5 };
		kadaneModified(numbers);
		kadane(numbers);

	}
}
