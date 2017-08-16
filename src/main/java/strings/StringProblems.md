## Basic String operations

* Sort a string:
  ```java
  Arrays.sort(str.toCharArray());
  ```

* Reverse a String:
  ```java
  new StringBuilder(str).reverse().toString();
  ```

* char[] arr to String:
  ```java
  new String(arr); OR String.valueOf(arr);
  ```

* String to ```List<Character>```:
  ```java
  str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
  ```
   * [Why is String.chars() a stream of ints in Java 8?](https://stackoverflow.com/questions/22435833/why-is-string-chars-a-stream-of-ints-in-java-8)

* ```List<String> to String[]```:
  ```java
  String[] strings = list.stream().toArray(String[]::new);
  ```
