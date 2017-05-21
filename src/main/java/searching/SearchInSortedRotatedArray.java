package searching;
/*
 Search an element in a sorted and rotated array.
 Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; key = 3
 Output : Found at index 8 
 
 Algorithm:
 1. First find the break (index of max - pivot) in the array.
 2. Implement Binary Search on the sub array.
 */

public class SearchInSortedRotatedArray {

	public static int getIndex(int[] arr, int key) {
		int n = arr.length;
		int pivot = findPivot(arr, 0, n - 1);
		if (pivot == -1) {
			return binarySearch(arr, 0, n - 1, key);
		}
		if (key == arr[0]) {
			return 0;
		}
		if (key < arr[0]) {
			return binarySearch(arr, pivot + 1, n - 1, key);

		} else {
			return binarySearch(arr, 0, pivot, key);
		}
	}

	public static int findPivot(int[] arr, int l, int r) {
		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (mid < r && arr[mid + 1] < arr[mid]) {
				return mid;
			}

			if (mid > l && arr[mid - 1] > arr[mid]) {
				return mid - 1;
			}

			if (arr[l] >= arr[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return -1;

	}

	public static int binarySearch(int[] arr, int l, int r, int key) {
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (key < arr[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 1, 2 };
		int key = 2;
		System.out.println(getIndex(arr, key));

	}

}
