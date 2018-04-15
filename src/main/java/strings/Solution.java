package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

class Solution {

	static int deletionDistance(String str1, String str2) {
		boolean[] charCount = new boolean[26];
		int count = 0;

		for (int i = 0; i < str1.length(); i++) {
			charCount[str1.charAt(i) - 'a'] = true;
		}

		for (int i = 0; i < str2.length(); i++) {
			if (!charCount[str2.charAt(i) - 'a']) {
				count++;
			}
		}

		return 0;

	}

	public static int findPairs(int[] nums, int k) {
		int pairs = 0;

		Set<Integer> set = new TreeSet<Integer>();
		// for (int i = 0; i < nums.length; i++) {
		// set.add(nums[i]);
		// }
		Arrays.stream(nums).forEach(e -> set.add(e));
		int[] arr = new int[set.size()];
		int i = 0, n = arr.length;

		for (int num : set) {
			arr[i++] = num;
		}

		for (int j = 0; j < n; j++) {
			if (j < n) {
				int v = arr[j] + k;
				if (binarySearch(arr, j + 1, n - 1, v)) {
					pairs++;
				}
			}

		}

		return pairs;

	}

	public static boolean binarySearch(int[] arr, int l, int r, int key) {
		int mid = 0;
		while (l <= r) {
			mid = (l + r) / 2;
			if (key == arr[mid]) {
				return true;
			}

			if (key < arr[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return false;
	}

	static int[] getIndicesOfItemWights(int[] arr, int limit) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {
				return new int[] { i, map.get(arr[i]) };
			}
			map.put(limit - arr[i], i);
		}

		return null;

	}

	// public static void main(String[] s) {
	// int[] arr = { 4, 3, 6, 8, 5, 1, 1, 2, 3 };
	//
	// int[] result = getIndicesOfItemWights(arr, 21);
	//
	// // Arrays.stream(result).forEach(e -> System.out.print(e + " "));
	//
	// Set<Integer> set = new HashSet<>();
	// Arrays.stream(arr).forEach(e -> set.add(e));
	// set.forEach(System.out::print);
	// System.out.println();
	// set.stream().filter(e -> e%2 == 0).forEach(System.out::print);
	//
	// PriorityQueue<String> q = new PriorityQueue<>();
	//
	//
	// }

	private static List<String> reverseStringsWhileKeepingWordsInOrder(List<String> strings) {
		// your code goes here
		List<String> result = new ArrayList<>();

		strings.forEach(sentence -> {
			String[] words = sentence.split("\\s");
			StringBuilder s = new StringBuilder();

			Arrays.stream(words).forEach(w -> {
				s.append(new StringBuilder().append(w).reverse());
				s.append(" ");
			});

			result.add(s.toString());
		});

		return result;
	}

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length, temp = 1;
		int[] result = new int[n];
		result[0] = 1;
		for (int i = 1; i < n; i++) {
			result[i] = temp * nums[i - 1];
			temp = temp * nums[i - 1];
		}
		temp = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			result[i] = result[i] * temp;
			temp = temp * nums[i];
		}

		return result;

	}

	public static void main(String[] s) {
		// List<String> list = new ArrayList<>();
		// list.add("abc xyz");
		// list.add("hello there");
		//
		// List<String> r = reverseStringsWhileKeepingWordsInOrder(list);
		//
		// r.forEach(System.out::println);

		int[] nums = { 1, 2, 3, 4 };

		Arrays.stream(productExceptSelf(nums)).forEach(e -> System.out.print(e + " "));

	}

}