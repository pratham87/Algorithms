package sorting;
/*
 Time Complexity: O(n^2)
 Space Complexity: O(1)
 
 Algorithm:
 
 1. Find the minimum element and place it the beginning 
 2. Update iMin
*/

public class SelectionSort {

	public static void selection(int[] a) {
		int temp, iMin; // iMin is used to track/remember minimum elements and
						// then swap
		for (int i = 0; i < a.length; i++) {

			iMin = i;

			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					iMin = j;
				}
			}

			if (iMin != i) {
				temp = a[i];
				a[i] = a[iMin];
				a[iMin] = temp;
			}
		}

		print(a);
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] a = { 9, 14, 3, 2, 43, 11, 58, 22 };
		System.out.println("Before sorting:");
		print(a);

		System.out.println("\n\nAfter sorting:");
		selection(a);
	}

}
