/**
 * 
 */
package p55;

import java.math.BigInteger;

/**
 * @author LG
 * 
 */
public class P55_LychrelNumbers {

	private static BigInteger reverse(BigInteger number) {
		char[] digits = number.toString().toCharArray();
		int low = 0, high = digits.length - 1;

		while (low < high) {
			char temp = digits[low];
			digits[low] = digits[high];
			digits[high] = temp;
			low++;
			high--;
		}

		return new BigInteger(String.valueOf(digits));
	}

	private static BigInteger iterate(BigInteger number) {
		return number.add(reverse(number));
	}

	private static boolean isPalindrom(BigInteger number) {
		return number.equals(reverse(number));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count = 0;

		for (int i = 1; i < 10000; i++) {
			boolean isLychrel = true;
			BigInteger number = BigInteger.valueOf(i);
			int j = 0;

			while (j <= 50 && isLychrel) {
				j++;
				number = iterate(number);
				isLychrel = !isPalindrom(number);
			}

			if (isLychrel) {
				count++;
			}
		}

		System.out.println(count);
	}
}