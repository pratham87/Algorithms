package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
 Sort List on email domain and username
 
 Algorithm:
 1. Concatenate domain + username.
 2. Use a TreeMap to sort all the keys and use it as a look up table to sort the list.
 */

public class SortOnDomainAndUsername {

	public static void sort(List<String> list) {

		Map<String, Integer> map = new TreeMap<>();
		List<String> result = new ArrayList<>();

		// Get every string, split it and put it in the map
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);

			String[] tokens = s.split("[ ,@.]+");
			map.put(tokens[3] + tokens[2], i);
		}

		// Use TreeMap as look up table and sort the list
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());

			result.add(list.get(entry.getValue()));

		}

		System.out.println();

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));

		}

	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("John Kerr, john@gmail.com, 21");
		list.add("Bagel Kerr, bagel@gmail.com, 31");
		list.add("Mary Kerr, mary@yahoo.com, 32");
		list.add("Lary Kerr, larry@yahoo.com, 45");
		list.add("Adam Kerr, adam@live.com, 41");
		list.add("Dam Kerr, dam@live.com, 67");

		sort(list);
	}

}
