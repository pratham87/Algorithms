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
		List<String> list = new ArrayList<>();
		List<Integer> intList = new ArrayList<>();

		Matcher match = Pattern.compile("\\d+").matcher(str);
		while (match.find()) {
			list.add(match.group());
		}

		list.forEach(e -> intList.add(Integer.valueOf(e)));

		intList.forEach(s -> System.out.print(s + " "));

		int sum = 0;
		for (Integer integer : intList) {
			sum = sum + integer;
		}
		return sum;
	}

	public static void main(String[] args) {

		System.out.println("\nSum is: " + find("abc1xy2mno78jh3khl21"));
	}

}
