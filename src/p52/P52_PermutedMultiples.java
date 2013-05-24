/**
 * 
 */
package p52;

/**
 * @author LG
 * 
 */
public class P52_PermutedMultiples {

	private static boolean isPermuted(long number1, long number2) {
		int[] digits1 = new int[10], digits2 = new int[10];
		int temp;

		while (number1 > 0) {
			temp = (int) (number1 % 10);
			digits1[temp]++;
			number1 /= 10;
		}

		while (number2 > 0) {
			temp = (int) (number2 % 10);
			digits2[temp]++;
			number2 /= 10;
		}

		for (int i = 0; i < 10; i++) {
			if (digits1[i] != digits2[i]) {
				return false;
			}
		}

		return true;
	}

	private static long findInDigits(int nDigits) {
		long low = 1;
		long high = 1;

		for (int i = 1; i < nDigits; i++) {
			low *= 10;
			high = high * 10 + 6;
		}

		for (long i = low; i <= high; i++) {
			boolean permuted = true;

			for (int j = 2; j <= 6; j++) {
				long temp = i * j;
				permuted = isPermuted(i, temp);

				if (!permuted) {
					break;
				}
			}

			if (permuted) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nDigits = 1;
		long number = -1;

		while (number == -1 && nDigits < 9) {
			nDigits++;
			number = findInDigits(nDigits);
		}

		System.out.println(number);
	}
}
