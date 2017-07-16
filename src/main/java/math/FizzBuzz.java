package math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>(n);
		int i = 0;
		while (i++ < n) {
			if (i % 3 == 0 && i % 5 == 0) {
				list.add("FizzBuzz");
			} else if (i % 5 == 0) {
				list.add("Buzz");
			} else if (i % 3 == 0) {
				list.add("Fizz");
			} else {
				list.add(String.valueOf(i));
			}
		}

		return list;

	}

	public static void main(String[] args) {
		List<?> list = fizzBuzz(15);
		System.out.println(list);
	}

}
