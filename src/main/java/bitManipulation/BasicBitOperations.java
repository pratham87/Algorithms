package bitManipulation;

public class BasicBitOperations {

	public static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}

	public static int getBitAtPosition(int n, int k) {
		return (n >> k) & 1;
	}

	public static int setBit(int n, int k) {
		return n | (1 << k);
	}

	public static int clearBit(int n, int k) {
		int mask = ~(1 << k);
		return n & mask;
	}

	public static int updateBit(int n, int k, int v) {
		int mask = ~(1 << k);
		return (n & mask) | (v << k);
	}

	public static void main(String[] args) {
		System.out.println("Get bit(1): " + getBit(14, 3));
		System.out.println("Get bit(2): " + getBitAtPosition(14, 3));
		System.out.println("Set bit: " + setBit(14, 3));
		System.out.println("Clear bit: " + clearBit(14, 3));
		System.out.println("Update bit: " + updateBit(14, 3, 0));
	}

}
