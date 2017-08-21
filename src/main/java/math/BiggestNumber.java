package math;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 Question: Generate the biggest number from the the given integer array:  
 Example {3,4,21,19,5} —> 5432119
         {7,5,87,89,9} -> 9898775
         {22,34,56} -> 563422        
         
  Algorithm:
  1. Single digit nums in Queue 1 and 2 digit nums in Queue 2.
  2. Compare every int and append it to the StringBuilder.       
 */

public class BiggestNumber {

	public static String getNum(int[] nums) {
		PriorityQueue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder result = new StringBuilder();

		for (int x : nums) {
			if (x < 10) {
				q1.add(x);
			} else if (x > 10 && x < 100) {
				q2.add(x);
			}
		}

		while (!q1.isEmpty() && !q2.isEmpty()) {
			if (q2.size() == 0 || q1.peek() > q2.peek() / 10) {
				result.append(q1.poll());
			} else {
				result.append(q2.poll());
			}
		}

		if (q1.isEmpty()) {
			while (!q2.isEmpty()) {
				result.append(q2.poll());
			}
		} else if (q2.isEmpty()) {
			while (!q1.isEmpty()) {
				result.append(q1.poll());
			}
		}

		return result.toString();

	}

	public static void main(String[] args) {
		int[] nums = { 7, 5, 87, 89, 9 };
		System.out.println(getNum(nums));

	}

}
