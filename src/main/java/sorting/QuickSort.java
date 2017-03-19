package sorting;

import java.util.Arrays;

/*
  Time Complexity: 
  	Best case: O(n log n)  
  	Worst case: O(n^2)
  Space Complexity: O(1)
  
1. Select a pivot
2. From both ends, swap elements and make left elements < pivot and all right > pivot
3. Recursively sort left part and right part 
 
*/

public class QuickSort {

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0 || low >= high) {
			System.out.println("Invalid array");
			return;
		}

		// select pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);

		if (high > i)
			quickSort(arr, i, high);
	}

	public static void main(String[] args) {
		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
		System.out.println("Unsorted array: \n" + Arrays.toString(x));

		int low = 0;
		int high = x.length - 1;

		quickSort(x, low, high);
		System.out.println("\n\nSorted array: \n" + Arrays.toString(x));
	}
}