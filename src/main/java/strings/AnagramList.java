package strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramList {

	public static List<String> anagram(List<String> list) {
		Map<String, List<String>> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			char[] wordArr = list.get(i).toCharArray();
			Arrays.sort(wordArr);
			String sortedWord = new String(wordArr);

			// Using Java 8 Lambda
			map.computeIfAbsent(sortedWord, s -> new ArrayList<>()).add(list.get(i));

			/* Using Java 7
			if (!map.containsKey(sortedWord)) {
				map.put(sortedWord, new ArrayList<String>());
				map.get(sortedWord).add(list.get(i));
			} else {
				map.get(sortedWord).add(list.get(i));
			}
			*/
		}

		map.values().stream().forEach(l -> {
			result.addAll(l);
		});

		return result;

	}

	public static void main(String[] args) throws IOException {

		List<String> words = Arrays.asList("live", "evil", "vile", "hello");
		anagram(words).forEach(w -> System.out.print(w + " "));

	}

}
