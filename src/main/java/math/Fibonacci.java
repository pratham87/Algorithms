package math;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	private Map<Integer, Long> map = new HashMap<Integer, Long>();

	public Fibonacci() {
		map.put(0, 0L); // fibonacci(0)
		map.put(1, 1L); // fibonacci(1)
	}

	public long fibonacci(int x) {
		return map.computeIfAbsent(x, arg -> fibonacci(x - 1) + fibonacci(x - 2));
	}

	public static void main(String s[]) {
		Fibonacci fibo = new Fibonacci();
		System.out.println(fibo.fibonacci(6));
	}
}

/* Working

fibonacci sequence 0,1,1,2,3,5,8,13,21....

Example:
fibonacci(5) = fibonacci(4) + fibonacci(3)
fibonacci(3) = fibonacci(2) + fibonacci(1)
fibonacci(4) = fibonacci(3) + fibonacci(2)
fibonacci(2) = fibonacci(1) + fibonacci(0)

Now,
fibonacci(2) = 1+0 = 1
fibonacci(3) = 1+1 = 2
fibonacci(4) = 2+1 = 3
fibonacci(5) = 3+2 = 5

*/