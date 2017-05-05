package strings;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Test {
	
	static int xyz = 0;

	public static int removeElement(int[] nums, int val) {
		int i = 0, v = 0;
		while (i < nums.length) {
			if (nums[i] != val) {
				nums[i] = nums[v];
				i++;
				v++;
			}
		}
		return v;

	}

	public static void removeElementT(int[] nums, int val) {
		int i = 0, v = 0;
		while (i < nums.length) {
			if (nums[v] != val) {
				nums[i] = nums[v];
				i++;
				v++;
			} else {
				while (v != val && v < nums.length) {
					v++;
				}
			}
		}

	}

	public static void spiral(int[][] a) {
		int row = 0, col = 0, dir = 0, start = 0, end = 4;
		int len = a.length;
		while (row < len && col < len) {

			if (dir == 0) {
				while (col < end - 1) {
					System.out.print(a[row][col]);
					col++;
				}
				dir++;
			}

			if (dir == 1) {
				while (row < end - 1) {
					System.out.print(a[row][col]);
					row++;
				}
				dir++;
			}

			if (dir == 2) {
				while (col > start) {
					System.out.print(a[row][col]);
					col--;
				}
				dir++;
				start++;
				end--;
			}

			if (dir == 3) {
				while (row > start) {
					System.out.print(a[row][col]);
					row--;
				}
				dir = 0;
			}

		}
	}

	public static int thirdMax(int[] nums) {
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (set.add(nums[i])) {
				q.add(nums[i]);
			}
		}

		int i = 0;
		int qsize = q.size();
		if (qsize >= 3) {
			while (i < 2 && i < qsize) {
				q.remove();
				i++;
			}
			return q.remove();
		}

		return q.remove();
	}

	public static void print(int[][] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j <= nums.length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();

		}
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 1, 2, 3 } };

		int[] a = {-2147483648,1,1};

		// spiral(nums);

		System.out.println(thirdMax(a));
		System.out.println(xyz);

	}

}
