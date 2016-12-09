package searching;

public class BinarySearchUsingIterations {

	public static int binarySearch(int[] array, int x) {
		int l = 0;
		int r = array.length - 1;
		int mid;

		while (l <= r) {
			mid = l + (r - l) / 2;

			if (array[mid] == x) {
				return mid;
			}

			if (x < array[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5 };

		System.out.println(binarySearch(array, 1));
	}

}
