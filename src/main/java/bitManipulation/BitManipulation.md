## Bit Manipulation

* ### **Truth table:** 
	* A and B are the inputs.

      | A | B | AND |OR |XOR|
      | :-|:- |:-   |:- |:- |
      | 0 | 0 | 0   |0  | 0 |
      | 0 | 1 | 0   |1  | 1 |
      | 1 | 0 | 0   |1  | 1 |
      | 1 | 1 | 1   |1  | 0 |

* ### **Two's complement:**
	* A positive number is represented as itself while a negative number is represented as the two's complement of its absolute value (with a 1 in its sign bit to indicate that it's a negative value). 
	* Trick: Scan bits from left until you hit 1 and then invert all the bits

* ### **Bits and Bytes:**
  * Bit:
      * A bit can store 0's or 1's
      * 1 Bit can store 2 patters ie; 0 1
      * 2 bits can store 4 patterns is; 00 01 10 11 
      * n bits yields 2<sup>n</sup> patterns
  * Byte: 
      * 1 byte = 8 bits
      * Can store one letter 'A' or 'a'
  * word: Made up of bytes
  * Integer: 4 bytes (32 bits)
  * Float: 4 bytes
  * char: 2 bytes

* ### **Arithmetic shift vs logical shift:**
    * Let int a = 60, b = 8;

  * **Arithmetic Left shift:** Left shift by n is equivalent to multiplying by 2<sup>n</sup>
      * Ex: a << 2 
          * a *  2<sup>2</sup>
          * 240

  * **Arithmetic Right shift:** Right shift by n is equivalent to dividing by 2<sup>n</sup>
      * Ex: a >> 2
          *  60/2<sup>2</sup>
          * 15

  * **Logical right shift:** 
  	  * Its same as as >> right shift except for negative nos
      * Ex: -1 >>> 1 = 2147483647
      * whereas  -1 >> 1 = -1
      * **So >>> shifts all the bits along with sign bit to the right whereas >> shifts all the bits to the right but preserves the sign bit (1 for -ve and 0 for +ve)**

  * AND:
      * Ex: a & b  (0011 1100  &  0000 1000)
      * 8

  * OR:
      * Ex: a | b  (0011 1100  |  0000 1000)
      * 60

  * XOR:
      * Ex: a ^ b  (0011 1100  ^  0000 1000)
      * 52


* ### **Endianness**:
	* Big Endian:
    	* Most significant byte of word is stored at smallest address and least significant byte is stored at largest address
    	 
           ![big-endian svg](https://cloud.githubusercontent.com/assets/23204433/24479246/22217962-1493-11e7-81d6-c346f6e8275e.png)

	* Little Endian:
    	* Most significant byte of word is stored at largest address and least significant byte is stored at smallest address
    	 
           ![little-endian svg](https://cloud.githubusercontent.com/assets/23204433/24479291/5a625a30-1493-11e7-9f9d-4549e876cbbc.png)

* ### **Common Bit Tasks**:
	* **Get Bit:** 
		* Aligning bit 1 with kth bit
		* Why AND: So that original bit (kth bit in N) won't be changed.
		
		* Method 1: 
			* Shift N by K bits. That way you will have the kth bit at the least significant position (end).
			* Then perform AND with 1. This will clear all the bits except the bit at the end. Thus you will get the bit (1 or 0) at position k in n. 
			```
            public static int getBit(int n, int k) {
                    return (n >> k) & 1;
                }
			```
		* Method 2: 
			*  Shift 1 over by k bits, to align bit 1 with the kth bit.
			*  Perform AND with N to clear all bits except the bit at kth position
			```
            public static boolean getBit(int n, int k) {
				return ((n & (1 << k)) != 0);
			}
            ```

	* **Set Bit:**
		*  Shift 1 over by k bits, to align bit 1 with the kth bit.
		*  Performing OR with N will change the bit at kth position in N
		*  All other bits will remain unchanged (since OR with 0)
			```
            public int setBit(int n, int k) {
				return n | (1 << k);
			}
            ```	 
            
     * **Clear Bit:**
     	* Reverse of setBit (setting a 0 instead of 1)
     	* Shift 1 over by k bits and then negate it, ~00010000 = 11101111
     	* This will clear the kth bit and leave the remainder unchanged.
          ```
          public static int clearBit(int n, int k) {
              int mask = ~(1 << k);
              return n & mask;
          }
          ```

	* **Update Bit:** (Set Bit + Clear Bit)
		* Left shift v by k bits
		* Clear the kth bit in N
		* OR both numbers to set v in N.
          ```
          public static int updateBit(int n, int k, int v) {
			  int mask = ~(1 << k);
			  return (n & mask) | (v << k);
		  }
          ```
          
          
