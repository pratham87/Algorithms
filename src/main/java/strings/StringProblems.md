## String Problems and Algorithms

1. Basic String operations:
	* Sort a string:
      ```
      Arrays.sort(str.toCharArray());
      ```

	* Reverse a String:
      ```
      new StringBuilder(str).reverse().toString();
      ```

	* char[] arr to String:
      ```
	  new String(arr);
      ```


2. Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
Example: Input:"abccccdd", Output: 7. 
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

	* **Algorithm:**
		* Use TreeMap to count every Character.
		* Get every Character with even value and add 1 to the output. 