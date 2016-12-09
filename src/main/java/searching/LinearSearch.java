package searching;

import java.util.Scanner;

public class LinearSearch {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
		int n, search, array[];

		Scanner in = new Scanner(System.in);
		System.out.println("Enter number of elements");
		n = in.nextInt();
		array = new int[n];

		System.out.println("Enter " + n + " integers");

		for (int c = 0; c < n; c++) {
			array[c] = in.nextInt();
		}

		System.out.println("Enter value to find");
		search = in.nextInt();

		linearSearch(array, search);

	}

	public static boolean linearSearch(int[] number, int searchElement) {
		for (int i = 0; i < number.length; i++) {
			if (number[i] == searchElement) {
				System.out.println(searchElement + " is present at location " + (i + 1) + ".");
				return true;
			}
		}
		System.out.println(searchElement + " is not present in array.");
		return false;
	}
}
