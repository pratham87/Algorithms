## Basic String operations

* #### Sort a string:
  ```java
  Arrays.sort(str.toCharArray());
  ```

* #### Reverse a String:
  ```java
  new StringBuilder(str).reverse().toString();
  ```

* #### char[] arr to String:
  ```java
  new String(arr); OR String.valueOf(arr);
  ```

* #### String to ```List<Character>```:
  ```java
  str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
  ```
   * [Why is String.chars() a stream of ints in Java 8?](https://stackoverflow.com/questions/22435833/why-is-string-chars-a-stream-of-ints-in-java-8)

* #### ```List<String> to String[]```:
  ```java
  String[] strings = list.stream().toArray(String[]::new);
  ```
  
* #### char to int:
  ```java
  String s = "1234";
  int x = Character.getNumericValue(s.charAt(2)); //Way 1
  int y = (int) (s.charAt(2) - '0'); //Way 2
  ```
* #### int to char:
  ```java
  int count = 1;
  char c = (char)(count + '0')
  ```

* #### String to Integer:
  ```java
  Integer.parseInt(str); OR new Integer(str);
  ```
* #### compareTo():
	* Java sorts Strings [lexicographically](http://docs.oracle.com/javase/8/docs/api/java/lang/String.html#compareTo-java.lang.String-) ie; char by char.
	* How it works: [Video](https://www.youtube.com/watch?v=iTC43mLZG38)
		* ```"adh".compareTo("abc")```: 
			* ASCII(a) - ASCII(a) = 0, so continue
			* ASCII(d) - ASCII(b) = 2. Stop
			* Result = 2, thus adh > abc
			* Algorithm keeps going until it finds first pair of different chars. 
* #### indexOf():
	* ```str.indexOf('a')```    ----> returns index of first occurence of char 'a'
	* ```str.indexOf('a', 2)``` ----> returns index of first occurence of char 'a' after index 2
	* ```str.indexOf("str2")``` ----> returns index of first occurence of String str2 first char in String str
	* ```str.indexOf("str2", 2)``` ----> returns index of first occurence of String str2 first char in String str after index 2
* ### **Regex**:
	* Valid usage of capitals (Valid words: Hello, hello or HELLO):
      ```java
      word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
      ```
    * [Keyboard Problem](https://leetcode.com/problems/keyboard-row/description/)
      ```java
      str.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")
      ```
