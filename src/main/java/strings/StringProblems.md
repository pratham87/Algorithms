## Basic String operations

* ##### Sort a string:
  ```java
  Arrays.sort(str.toCharArray());
  ```

* ##### Reverse a String:
  ```java
  new StringBuilder(str).reverse().toString();
  ```

* ##### char[] arr to String:
  ```java
  new String(arr); OR String.valueOf(arr);
  ```

* ##### String to ```List<Character>```:
  ```java
  str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
  ```
   * [Why is String.chars() a stream of ints in Java 8?](https://stackoverflow.com/questions/22435833/why-is-string-chars-a-stream-of-ints-in-java-8)

* ##### ```List<String> to String[]```:
  ```java
  String[] strings = list.stream().toArray(String[]::new);
  ```
  
* ##### char to int:
  ```java
  String s = "1234";
  int x = Character.getNumericValue(s.charAt(2)); //Way 1
  int y = (int) (s.charAt(2) - '0'); //Way 2
  ```

* ##### String to Integer:
  ```java
  Integer.parseInt(str); OR new Integer(str);
  ```

* ### **Regex**:
	* Valid usage of capitals (Valid words: Hello, hello or HELLO):
      ```java
      word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
      ```
    * [Keyboard Problem](https://leetcode.com/problems/keyboard-row/description/)
      ```java
      str.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")
      ```
