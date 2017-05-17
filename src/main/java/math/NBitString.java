package math;

import java.util.Arrays;

/*
 	Gen­er­ate All Strings of n bits, con­sider A[0..n-1] is an array of size n.
	Exam­ple : n = 3
	Output:
	[0, 0, 0]    [1, 0, 0]    [0, 1, 0]    [1, 1, 0]
	[0, 0, 1]    [1, 0, 1]    [0, 1, 1]    [1, 1, 1] 
	
	Algorithm: Nested Recursion
	1. When data is returned at the very end, make more operations and do another recursive call. 
	2. Insert data, make recursive call (Alternate pattern).
 */

public class NBitString {

	int[] arr;

	public NBitString(int n) {
		arr = new int[n];
	}

	public void nBits(int n) {
		if (n <= 0) {
			System.out.println(Arrays.toString(arr));
		} else {
			arr[n - 1] = 0;
			nBits(n - 1);
			arr[n - 1] = 1;
			nBits(n - 1);
		}

	}

	public static void main(String[] args) {
		int n = 3;
		NBitString nb = new NBitString(n);
		nb.nBits(n);
	}

}
