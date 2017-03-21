package sorting;

/*
 Time Complexity: O(n^2)
 Space Complexity: O(1)

 Algorithm:
 
 1. Compare array[0] & array[1] 
 2. If array[0] > array [1] swap it. 
 3. Compare array[1] & array[2] 
 4. If array[1] > array[2] swap it. ... 
 5. Compare array[n-1] & array[n] 
 6. if [n-1] > array[n] then swap it.
 
 7. After this step we will have largest element at the last index.
 
 8. Repeat the same steps for array[1] to array[n-1]
 
 */
public class BubbleSort {

	private static void bubbleSort(int[] intArray) {

		int n = intArray.length;
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {

				if (intArray[j - 1] > intArray[j]) {
					temp = intArray[j - 1];
					intArray[j - 1] = intArray[j];
					intArray[j] = temp;
				}

			}
		}

	}

	public static void main(String[] args) {

		// create an int array we want to sort using bubble sort algorithm
		int[] intArray = new int[] { -1, 90, 35, 45, 150, -3 };

		// print array before sorting using bubble sort algorithm
		System.out.println("Array Before Bubble Sort");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

		// sort an array using bubble sort algorithm
		bubbleSort(intArray);

		System.out.println("");

		// print array after sorting using bubble sort algorithm
		System.out.println("Array After Bubble Sort");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}

	}

}
