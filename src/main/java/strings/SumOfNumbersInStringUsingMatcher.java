package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  Create a function that finds the sum of all the integers in a string
  (“abc1xy2mno78jh3khl21”). Continuous integers are considered one number.
*/
public class SumOfNumbersInStringUsingMatcher {

	public static int find(String str) {
		List<Integer> list = new ArrayList<>();

		Matcher match = Pattern.compile("\\d+").matcher(str);
		while (match.find()) {
			list.add(Integer.valueOf(match.group()));
		}

		return list.stream().mapToInt(i -> i.intValue()).sum();

	}

	public static void main(String[] args) {

		System.out.println("\nSum is: " + find("abc1xy2mno78jh3khl21"));
	}

}
