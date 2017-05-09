package strings;

/*

Convert every letter to its ASCII value. Add 1 to the first letter, and for every letter from the second to the last, add to it the value of the previous letter. 
Subtract 26 from every letter until it is in the range of lowercase letters a-z in ASCII. 
Convert the values back to letters.
For instance, to encrypt the word “crime”

Decrypted message:	c	r	i	m	e
Step 1:			99	114	105	109	101
Step 2:			100	214	319	428	529
Step 3:			100	110	111	116	113
Encrypted message:	d	n	o	t	q

 Algorithm:
 1. Subtract ASCII value of prev letter from current letter.
 2. Add 26 until it gets in the range (97 - 122: a-z)
 3. Convert back to char
 */

public class DecryptionProblem {

	public static String decrypt(String word) {
		StringBuilder s = new StringBuilder();
		s.append((char) ((int) word.charAt(0) - 1));

		for (int i = 1; i < word.length(); i++) {
			int letterASCII = (int) word.charAt(i) - (int) word.charAt(i - 1);

			while (letterASCII < (int) 'a') {
				letterASCII += 26;
			}

			s = s.append((char) letterASCII);
		}

		return s.toString();
	}

	public static void main(String[] args) {
		System.out.println(decrypt("dnotq"));

	}

}
