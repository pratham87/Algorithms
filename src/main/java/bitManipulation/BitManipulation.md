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

	* Little Endian:
    	* Most significant byte of word is stored at largest address and least significant byte is stored at smallest address