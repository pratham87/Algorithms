package sorting;
/*
 Time Complexity: O(n^2) - Same for Best, Average, Worst cases.
 Space Complexity: O(1)
 
 Algorithm:
 
 1. Use iMin pointer to find the minimum element in the array. Initially point iMin to index 0. 
 2. Keep updating iMin whenever a min element is found. 
 3. Then swap and place the min element at the beginning of the array (i)
 4. Update i and repeat the same procedure.
*/

public class SelectionSort {

	public static void selection(int[] a) {
		int temp, iMin; // iMin is used to track/remember minimum element
						
		for (int i = 0; i < a.length; i++) {

			iMin = i;

			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					iMin = j;
				}
			}
			
			//Swap if iMin is updated (pointing to different element)
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
