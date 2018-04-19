## Understanding Recursion
* Base case: 
	* What should it return? 
	* Whats the objective. Whats the value that we need to solve the problem.
* Recursive calls:
	* Method signature should consist of data points subject to change. Example: BinarySearch method has left and right pointers which change with every iteration. Constants can be in the method signature or global.
	* Make calls on valid positions. 
	* Solve it for a subproblem (starting subproblem).
	* After it returns the value, what to do with that result?

* Example: Factorial or Fibonacci.
