/**
 * 
 */
package p41;

import java.util.ArrayList;

/**
 * @author LG
 * 
 */
public class P41_PandigitalPrimes {

	private static boolean isPrime(long number) {
		long sqrt = (long) Math.sqrt(number);

		for (int i = 2; i <= sqrt; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	private static long toLong(int[] digits) {
		long result = 0;

		for (int i = 0; i < digits.length; i++) {
			result = result * 10 + digits[i];
		}

		return result;
	}

	private static long findInCombinations(int digit) {
		long number = -1;
		int[] digits = new int[digit];

		for (int i = 0; i < digits.length; i++) {
			digits[i] = digit - i;
		}

		number = toLong(digits);

		if (isPrime(number)) {
			return number;
		}

		int i = digits.length - 1;

		do {
			i = digits.length - 2;

			while (i >= 0 && digits[i] < digits[i + 1]) {
				i--;
			}

			if (i >= 0) {
				int j = digits.length - 1;

				while (digits[j] > digits[i]) {
					j--;
				}

				int temp = digits[i];
				digits[i] = digits[j];
				digits[j] = temp;

				int a = i + 1, b = digits.length - 1;

				while (a < b) {
					temp = digits[a];
					digits[a] = digits[b];
					digits[b] = temp;
					a++;
					b--;
				}
			}

			number = toLong(digits);

			if (isPrime(number)) {
				return number;
			}
		} while (i >= 0);

		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Because sum of digits of 9-numbers is 45 and 8-numbers is 36
		// so 9-numbers and 8-numbers are always divisible by 3
		// so they can not be primes
		// we start with the permutations of 7
		int digits = 7;
		long number = -1;

		while (number == -1) {
			number = findInCombinations(digits);
			digits--;
		}

		System.out.println(number);
	}
}
