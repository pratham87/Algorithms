package backtracking;

public class MazeRunner {
	int[][] sol;

	public MazeRunner(int n) {
		sol = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sol[i][j] = 0;
			}
		}
	}

	public void printSolution(int[][] maze, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + sol[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean isValidPosition(int[][] maze, int i, int j, int n) {

		return (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1);
	}

	public boolean findPath(int[][] maze, int i, int j, int n, String direction) {
		if (i == n - 1 && j == n - 1) {
			sol[i][j] = 1;
			return true;
		}

		if (isValidPosition(maze, i, j, n)) {
			sol[i][j] = 1;

			if (direction != "up" && findPath(maze, i + 1, j, n, "down")) {
				return true;
			}

			if (direction != "left" && findPath(maze, i, j + 1, n, "right")) {
				return true;
			}

			if (direction != "down" && findPath(maze, i - 1, j, n, "up")) {
				return true;
			}

			if (direction != "right" && findPath(maze, i, j - 1, n, "left")) {
				return true;
			}

			sol[i][j] = 0;
			return false;

		}

		return false;
	}

	public void solve(int[][] maze, int i, int j, int n) {
		if (findPath(maze, i, j, n, "down")) {
			printSolution(maze, n);
		} else {
			System.out.println("Solution not available");
		}

	}

	public static void main(String[] args) {

		int[][] maze = { { 1, 1, 1, 1, 1 }, 
						 { 1, 1, 1, 1, 1 }, 
						 { 0, 0, 1, 1, 1 }, 
						 { 1, 0, 1, 0, 1 },
						 { 1, 1, 1, 0, 1 } };

		MazeRunner mazeR = new MazeRunner(5);
		mazeR.solve(maze, 0, 0, 5);
	}

}
