package backtracking;

public class WordInMatrix {
	int[][] solution;

	public WordInMatrix(int n) {
		solution = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				solution[i][j] = 0;
			}
		}
	}

	public void printSolution(int[][] matrix) {
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				System.out.print(" " + matrix[i][j] + " ");
			}
		}
	}

	public boolean traceWord(char[][] matrix, int n) {
		return false;
	}

	public boolean findWord(char[][] matrix, int n) {
		return traceWord(matrix, n);

	}

	public static void main(String s[]) {
		WordInMatrix wmat = new WordInMatrix(5);
		char[][] matrix = { { 't', 'z', 'x', 'c', 'd' }, { 'a', 'h', 'n', 'z', 'x' }, { 'h', 'w', 'o', 'i', 'o' },
				{ 'o', 'r', 'n', 'r', 'n' }, { 'a', 'b', 'r', 'i', 'n' } };

		System.out.println("Word found: " + wmat.findWord(matrix, 5));
	}
}
