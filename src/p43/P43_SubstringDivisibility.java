/**
 * 
 */
package p43;

import java.util.Arrays;

import peutils.Utils;

/**
 * @author LG
 * 
 */
public class P43_SubstringDivisibility {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] primes = { 2, 3, 5, 7, 11, 13, 17 };
		boolean hasNextGeneration = true;
		long sum = 0;

		do {
			boolean isDivisible = true;

			for (int i = 0; i < 7; i++) {
				long number = Utils.getNumberFromDigits(digits, i + 1, 3);

				if (number % primes[i] != 0) {
					isDivisible = false;
					break;
				}
			}

			if (isDivisible) {
				System.out.println(Arrays.toString(digits));
				long number = Utils.getNumberFromDigits(digits);
				sum += number;
			}

			hasNextGeneration = Utils.nextGeneration(digits);
		} while (hasNextGeneration);

		System.out.println(sum);
	}
}