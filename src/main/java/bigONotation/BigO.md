## Big O Notation

* Big O notation is a way to measure the efficiency of an algorithm (how well a computer algorithm scales as the amount of data increases).
* Basically how many times does your algorithm reads the data in memory.
* Its not a measure of speed but efficiency. 
* For example:
	* n<sup>4</sup> + n<sup>3</sup> + 1 : O(n<sup>4</sup>)
* ### **O(1):** 
  * An algorithm that executes in the same time regardless of the amount of data. 
  * Reading the data only once gives O(1).
  * Below code executes in the same amount of time no matter how big the array is:
  ```
  public void add(int x) {
          array[0] = x;
      }
  ```
* ### **O(n):** 
	* Example: Linear search 
	* Time to complete is directly proportional to the amount of data. 
	* Reading every data in array. So reading N elements gives O(n)

* ### **O(n<sup>2</sup>)** 
	* Example: Bubble sort
	* Time to complete the algorithm is directly proportional to the square of the amount of data. 
	* Algorithms with more nested iterations will result in O(n<sup>2</sup>), O(n<sup>3</sup>), etc. performance
	* Reading every data N times in array. So reading N elements gives O(n<sup>2</sup>) 

* ### **O(log n):** 
	* Example: Binary Search
	* log N occurs when the data being used is decreased by roughly **50%** each time through the algorithm. 
	* As the value N increases, the value of log N decreases
	* O(log n) algorithms are very efficient because increasing the amount of data has little effect as the amount of data is halved on each run.

* ### **O(n log n):** 
	* Example: Quick sort
	* Values are compared only once. 
	* So each comparison will reduce the possible final sorted lists in half.
    * Comparisons = log n! 
    * Comparisons = log n + log(n-1) + .... + log(1) = n log n
