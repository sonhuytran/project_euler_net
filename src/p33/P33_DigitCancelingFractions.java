/**
 * 
 */
package p33;

import java.util.Arrays;

import peutils.Utils;

/**
 * @author LG
 * 
 */
public class P33_DigitCancelingFractions {

	private static int[] getDigits(int number) {
		int[] digits = new int[2];
		digits[1] = number % 10;
		digits[0] = number / 10;

		return digits;
	}

	private static boolean isEqual(int i1, int j1, int i2, int j2) {
		return ((i1 * j2) == (i2 * j1));
	}

	private static boolean isCancelable(int i, int j) {
		if (i % 10 == 0 && j % 10 == 0) {
			// trivial examples
			return false;
		}

		int[] digitsI = getDigits(i);
		int[] digitsJ = getDigits(j);

		if (digitsI[0] == digitsJ[0] && isEqual(i, j, digitsI[1], digitsJ[1])) {
			return true;
		}

		if (digitsI[0] == digitsJ[1] && isEqual(i, j, digitsI[1], digitsJ[0])) {
			return true;
		}

		if (digitsI[1] == digitsJ[0] && isEqual(i, j, digitsI[0], digitsJ[1])) {
			return true;
		}

		if (digitsI[1] == digitsJ[1] && isEqual(i, j, digitsI[0], digitsJ[0])) {
			return true;
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numerators = new int[4];
		int[] denominators = new int[4];
		int index = 0;

		for (int i = 10; i < 99; i++) {
			for (int j = i + 1; j < 100; j++) {
				if (isCancelable(i, j)) {
					System.out.println(i + "/" + j);
					numerators[index] = i;
					denominators[index] = j;
					index++;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			int lcd = Utils
					.largestCommonDivisor(numerators[i], denominators[i]);
			numerators[i] /= lcd;
			denominators[i] /= lcd;
		}

		System.out.println(Arrays.toString(numerators));
		System.out.println(Arrays.toString(denominators));

		int resultNumerator = 1, resultDenominator = 1;

		for (int i = 0; i < 4; i++) {
			resultNumerator *= numerators[i];
			resultDenominator *= denominators[i];
		}

		int lcd = Utils
				.largestCommonDivisor(resultNumerator, resultDenominator);
		resultNumerator /= lcd;
		resultDenominator /= lcd;

		System.out.println(resultNumerator + "/" + resultDenominator);
	}
}
