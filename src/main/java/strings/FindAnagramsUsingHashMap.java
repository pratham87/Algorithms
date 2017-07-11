package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  Algorithm: Sliding window algorithm
  
  1. Get all the chars and their count in HashMap. Create a window with start and end pointers.
  2. IMP: Use COUNTER to find valid/invalid anagram substrings. Counter = 0: Valid anagram.
  3. Move the window by a single char. 
  4. When a char gets in the window, decrement its value and counter by 1.
  	 When a char leaves the window, increment its value and counter by 1.	
 */
public class FindAnagramsUsingHashMap {

	public static List<Integer> findAnagrams(String s, String p) {
		int start = 0, end = 0;
		List<Integer> list = new ArrayList<>();
		if (p.length() > s.length()) {
			return list;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char c : p.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int counter = map.size();

		while (end < s.length()) {
			if (map.containsKey(s.charAt(end))) {
				map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
				if (map.get(s.charAt(end)) == 0) {
					counter--;
				}
			}
			end++;

			if (counter == 0) {
				list.add(start);
			}

			if (end - start == p.length()) {
				if (map.containsKey(s.charAt(start))) {
					map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
					if (map.get(s.charAt(start)) > 0) {
						counter++;
					}
					start++;
				} else {
					start++;
				}

			}
		}
		return list;

	}

	public static void main(String[] args) {
		findAnagrams("cbabac", "abc").forEach(e -> System.out.print(e + " "));
	}

}
