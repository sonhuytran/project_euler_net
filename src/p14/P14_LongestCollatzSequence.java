/*
 * 
 */
package p14;

import java.io.IOException;

/**
 * @author mtpham
 * 
 */
public class P14_LongestCollatzSequence {

	/**
	 * 
	 */
	public P14_LongestCollatzSequence() {
		// TODO Auto-generated constructor stub
	}

	private static int length(long number) {
		if (number <= 1) {
			return 1;
		}

		int length = 1;

		while (number > 1) {
			if (number % 2 == 0) {
				number = number / 2;
			} else {
				number = number * 3 + 1;
			}

			length++;
		}

		return length;
	}

	/**
	 * @param args
	 * @throws IOException throw
	 */
	public static void main(String[] args) throws IOException {
		long maxLength = 1;
		long maxNumber = 1;

		for (long i = 2; i < 1000001; i++) {
			int currentLength = length(i);

			if (currentLength > maxLength) {
				maxLength = currentLength;
				maxNumber = i;
			}
		}
		
		System.out.println(maxNumber);
		System.out.println(maxLength);
	}

}
