package dynamicProgramming;

/*
 Input:  mat[][] = {{1, 2, 9}
                    {5, 3, 8}
                    {4, 6, 7}}
Output: 4
The longest path is 6-7-8-9.  
 */

public class LongestPathInMatrix {

	public static int numPaths(int[][] mat, int n) {
		int paths = 1;
		int[][] memo = new int[n][n];

		// Step1: Initialize memo[][]
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				memo[i][j] = -1;
			}
		}

		// Step 5: Call method on every cell as recursion won't touch every cell
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (memo[i][j] == -1) {
					findPath(mat, i, j, n, memo);
				}

				paths = Math.max(paths, memo[i][j]);

			}
		}

		return paths;

	}

	public static int findPath(int[][] mat, int i, int j, int n, int[][] memo) {

		// Step 2: Base condition
		if (i < 0 || i >= n || j < 0 || j >= n) {
			return 0;
		}

		// Step 3: Look up memo
		if (memo[i][j] != -1) {
			return memo[i][j];
		}

		// Step 4: Recurse on every valid cell
		if (i < n - 1 && ((mat[i][j] + 1) == mat[i + 1][j])) {
			return memo[i][j] = 1 + findPath(mat, i + 1, j, n, memo);
		}

		if (i > 0 && ((mat[i][j] + 1) == mat[i - 1][j])) {
			return memo[i][j] = 1 + findPath(mat, i - 1, j, n, memo);
		}

		if (j < n - 1 && ((mat[i][j] + 1) == mat[i][j + 1])) {
			return memo[i][j] = 1 + findPath(mat, i, j + 1, n, memo);
		}

		if (j > 0 && ((mat[i][j] + 1) == mat[i][j - 1])) {
			return memo[i][j] = 1 + findPath(mat, i, j - 1, n, memo);
		}

		return memo[i][j] = 1;

	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 9 }, { 5, 3, 8 }, { 4, 6, 7 } };

		System.out.println(numPaths(mat, 3));

	}

}
