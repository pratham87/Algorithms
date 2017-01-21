package sorting;

public class SelectionSort {

	public static void selection(int[] a) {
		int temp, iMin;
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
