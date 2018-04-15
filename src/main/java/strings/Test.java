package strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {

	public int test(int[][] data) {
		int initial = data[0][0], max = 0, sum = 0, timestamp = 0;
		for (int i = 0; i < data.length; i++) {
			if (initial != data[i][0] || i == data.length - 1) {
				if (sum > max) {
					max = sum;
					timestamp = initial;
				}
				initial = data[i][0];
				sum = 0;
			}

			if (data[i][2] == 1) {
				sum += data[i][1];
			} else {
				sum -= data[i][1];
			}
		}

		return timestamp;

	}

	public static int[] sortKMessedArray(int[] arr, int k) {
		if (arr.length == 0 || arr == null || k < 0) {
			throw new IllegalArgumentException();
		}

		PriorityQueue<Integer> q = new PriorityQueue<>();
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (q.size() < k + 1) {
				q.add(arr[i]);
			} else {
				arr[j++] = q.poll();
				q.add(arr[i]);
			}

			if (i == arr.length - 1) {
				while (q.size() != 0) {
					arr[j++] = q.poll();
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		return arr;
	}

	public static int majorityElement(int[] nums) {
		int n = nums.length, count = 0, max = 0, majority = 0;
		if (n == 0 || nums == null) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			if (!set.add(nums[i])) {
				count++;
			} else {
				max = Math.max(max, count);
				majority = nums[i];
				count = 0;
			}
		}
		System.out.println(majority);
		return majority;
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer num : nums) {
			if (map.containsKey(num)) {
				int count = map.get(num);
				count++;
				map.put(num, count);
			} else {
				map.put(num, 1);
			}
		}
		List<Entry<Integer, Integer>> list = map.entrySet().stream()
				.sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList());

		for (Map.Entry<Integer, Integer> e : list) {
			if (k > 0) {
				result.add(e.getKey());
				k--;
			}
		}

		result.forEach(System.out::println);
		return result;

	}

	public int maxSubArray(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int max_here = 0;
		int max_so_far = nums[0];
		for (int x : nums) {
			max_here = Math.max(x, max_here + x);
			max_so_far = Math.max(max_so_far, max_here);
		}
		return max_so_far;
	}

	public static boolean seq(String input, String sample) {
		int i = 0, j = 0;
		while (i < input.length() && j < sample.length()) {
			if (input.charAt(i) == sample.charAt(j)) {
				j++;
			} else if (i == input.length() - 1) {
				return false;
			}
			i++;
		}

		return true;
	}

	public static boolean test(String a, String b, String c) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < a.length(); i++) {
			set.add(a.charAt(i));
		}
		for (int i = 0; i < c.length(); i++) {
			if (set.contains(c.charAt(i))) {
				set.remove(c.charAt(i));
			}
		}

		for (int i = 0; i < b.length(); i++) {
			if (set.add(b.charAt(i))) {
				return false;
			}
		}
		set.forEach(System.out::print);
		return true;
	}

	public static void test2(int[][] arr) {
		int i = 0, c = 0;
		while (i < arr.length) {
			System.out.print(arr[i++][c] + " ");
			if (i == arr.length && c < arr.length - 1) {
				c++;
				i = 0;
			}
		}
	}

	public static boolean wordPattern(String pattern, String str) {
		Map<Character, String> map = new HashMap<>();
		String[] words = str.split("\\s");
		if (pattern == null || str == null || pattern.length() == 0 || str.length() == 0
				|| pattern.length() != words.length) {
			return false;
		}
		for (int i = 0; i < pattern.length(); i++) {
			if (!map.containsKey(pattern.charAt(i)) && !map.containsValue(words[i])) {
				map.put(pattern.charAt(i), words[i]);
			} else if (!map.get(pattern.charAt(i)).equals(words[i])) {
				return false;
			}
		}
		return true;
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
		Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
		set1.retainAll(set2);
		return set1.stream().mapToInt(i -> i).toArray();
	}

	public static int test(String s) {
		Set<Character> set = new HashSet<>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (set.add(s.charAt(i))) {
				max = Math.max(max, set.size());
			} else {
				set.clear();
				set.add(s.charAt(i));
			}
		}

		return max;
	}

	// {0,0,1,1,1,5,5,6,6,6,6,7,11}, n = 5 -> output {5,6}
	public static int[] findFirstlastIndex(int[] arr, int n) {
		int l = 0, r = arr.length - 1;

		while (l < r) {
			int mid = (l + r) / 2;

			if (arr[mid] == n) {
				l = r = mid;
				while (l >= 0) {
					if (arr[l] == arr[mid]) {
						l--;
					} else {
						break;
					}
				}

				while (r <= arr.length - 1) {
					if (arr[r] == arr[mid]) {
						r++;
					} else {
						break;
					}
				}
				return new int[] { l + 1, r - 1 };
			} else if (arr[mid] < n) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return null;

	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[nums1.length];
		int n = nums2.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums2[j] > nums2[i]) {
					map.put(nums2[i], nums2[j]);
					break;
				}
			}
		}

		for (int k = 0; k < nums1.length; k++) {
			if (map.containsKey(nums1[k])) {
				int value = map.get(nums1[k]);
				result[k] = value;
			} else {
				result[k] = -1;
			}
		}

		return result;
	}

	public static char findTheDifference(String s, String t) {
		int[] temp = new int[26];
		for (int i = 0; i < t.length(); i++) {
			temp[t.charAt(i) - 'a'] += 1;
		}

		for (int i = 0; i < s.length(); i++) {
			temp[s.charAt(i) - 'a'] -= 1;
		}

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 1) {
				return (char) (i + 'a');
			}
		}
		return 0;
	}

	public Map<String, Integer> wordCount(String[] strings) {
		Map<String, Integer> map = new HashMap<>();
		for (String s : strings) {
			map.put(s, map.containsKey(s) ? new Integer(1) : map.get(s) + 1);
		}
		return map;
	}

	public static void test() {
		String a = "abc";

		System.out.println(a.matches("[A-Z][a-z]+"));
	}

	public boolean detectCapitalUse(String word) {
		int lowerCase = 0, upperCase = 0;
		if (word.length() < 2) {
			return true;
		} else {
			for (int i = 1; i < word.length(); i++) {
				if (Character.isUpperCase(word.charAt(0))) {
					if (Character.isLowerCase(word.charAt(i))) {
						lowerCase++;
					} else {
						upperCase++;
					}
					if (lowerCase > 0 && upperCase > 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static int countHi(String str) {
		int count = 0;
		Matcher m = Pattern.compile("(hi)").matcher(str);
		while (m.find()) {
			count++;
		}
		return count;
	}

	public int findLUSlength(String a, String b) {
		List<Character> listA = a.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		List<Character> listB = b.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		if (listA.size() > listB.size()) {
			listA.removeAll(listB);
			return listA.size() == 0 ? -1 : listA.size();
		} else {
			listB.removeAll(listA);
			return listB.size() == 0 ? -1 : listB.size();
		}
	}

	public int findLHS(int[] nums) {
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Integer i : map.keySet()) {
			if (map.containsKey(i + 1)) {
				max = Math.max(map.get(i) + map.get(i + 1), max);
			}
		}

		return max;
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0)
			return list;

		int[] hash = new int[256];
		for (char c : p.toCharArray()) {
			hash[c]++;
		}

		int left = 0, right = 0, count = p.length();
		while (right < s.length()) {
			if (hash[s.charAt(right++)]-- >= 1)
				count--;

			if (count == 0)
				list.add(left);

			if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
				count++;
		}
		return list;
	}

	public List<Integer> findAnagrams1(String s, String p) {
		int start = 0, end = 0, counter = p.length();
		List<Integer> list = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : p.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		while (end < s.length()) {
			if (map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) >= 1) {
				map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
				counter--;
			}

			if (counter == 0) {
				list.add(start);
			}

			if (end - start == p.length()) {
				map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
				counter++;
				start++;
				end++;
			}

		}
		return list;

	}

	public static boolean makeBricks(int small, int big, int goal) {
		int x = goal - (5 * big);
		if (x == 0) {
			return true;
		} else if (x < 0 && (goal - small) % 5 == 0) {
			return true;
		} else if (x > 0 && x - small <= 0) {
			return true;
		}
		return false;
	}

	public int countYZ(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetter(str.charAt(i)) && (str.charAt(i - 1) == 'y' || str.charAt(i - 1) == 'z')) {
				count++;
			}
		}
		return count;
	}

	public static String[] findWords(String[] words) {
		List<String> list = new ArrayList<>();
		for (String s : words) {
			if (s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")) {
				list.add(s);
			}
		}

		return list.stream().toArray(String[]::new);
	}

	public static void main(String[] args) throws IOException {
		// int[][] data = { { 1487799425, 14, 1 }, { 1487799425, 4, 0 }, {
		// 1487799425, 2, 0 }, { 1487800378, 10, 1 },
		// { 1487801478, 18, 0 }, { 1487801478, 18, 1 }, { 1487901013, 1, 0 }, {
		// 1487901211, 7, 1 },
		// { 1487901211, 7, 0 } };
		// System.out.println(new Test().test(data));

		// sort(new int[] { 1, 4, 5, 2, 3, 7, 8, 6, 10, 9 }, -2);

		// majorityElement(new int[] { 2, 3, 4, 3, 4, 3 });

		// System.out.println(Integer.reverse(123));

		// topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 3);

		// System.out.println(seq("abcNjAhgAhGjhfhAljhRkhgRbhjbevfhO",
		// "NAGARRO"));

		// test("axbyz", "xyz", "abc"); // utxyz

		// test2(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });

		// char a = '1';
		// char b = '1';
		//
		// System.out.println(a == b);
		//
		// String s = "sdsd123";
		// int sum = 0;
		// Matcher match = Pattern.compile("\\d").matcher(s);
		// while(match.find()){
		// sum = sum + Integer.valueOf(match.group());
		// System.out.println(match.group());
		// }
		// System.out.println(sum);

		// intersection(new int[] { 1, 2, 2, 3, 1 }, new int[] { 2, 2, 3 });

		// List<Integer> list = Arrays.asList(3, 6, 1, 7, 4);
		//
		// list.stream().sorted(Collections.reverseOrder()).forEach(e ->
		// System.out.print(e + " "));

		// char a = 'a';
		// char b = 'b';
		// int t = a - b;

		// List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		// list.forEach(System.out::println);
		//
		// System.out.println(test("abcabcdabc"));

		// System.out
		// .println(Arrays.toString(findFirstlastIndex(new int[] { 0, 0, 1, 1,
		// 1, 5, 5, 6, 6, 6, 6, 7, 11 }, 11)));

		// System.out.println(Arrays.toString(nextGreaterElement(new int[] { 4,
		// 1, 2 }, new int[] { 1, 3, 4, 2 })));

		// findTheDifference("a", "aa");

		// findLHS(new int[]{1,3,2,2,5,2,3,7});

		// System.out.println(makeBricks(3, 1, 8));

		// Arrays.asList(1, 1, 2, 2, 3).parallelStream().distinct().forEach(e ->
		// System.out.println(e));

		// List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 1, 1, 3, 3, 3);
		// numbers.stream().filter(i -> Collections.frequency(numbers, i) >
		// 1).collect(Collectors.toSet())
		// .forEach(System.out::println);

		// int[] arr = {1,2,2,3,3,4,4};
		// Arrays.stream(arr).boxed().collect(Collectors.toSet()).forEach(e ->
		// System.out.print(e + " "));
		//
		// Arrays.stream(arr).filter(e -> e%2 ==0).forEach(e ->
		// System.out.print(e + " "));

		System.out.println("adh".compareTo("abc"));

	}

}
