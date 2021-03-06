/**
 * 
 */
package peutils;

/**
 * @author Son-Huy TRAN
 * 
 */
public class Utils {

	public static int concat(int number1, int number2) {
		int temp = number2;

		while (temp > 0) {
			number1 *= 10;
			temp /= 10;
		}

		return number1 + number2;
	}

	public static int largestCommonDivisor(int a, int b) {
		while (b > 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}

		return a;
	}

	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static boolean nextGeneration(int[] digits) {
		if (digits.length < 2) {
			return false;
		}

		int i = digits.length - 2;

		while (i >= 0 && digits[i] > digits[i + 1]) {
			i--;
		}

		if (i < 0) {
			return false;
		}

		int j = digits.length - 1;

		while (digits[j] < digits[i]) {
			j--;
		}

		Utils.swap(digits, i, j);

		int low = i + 1, high = digits.length - 1;

		while (low < high) {
			Utils.swap(digits, low, high);
			low++;
			high--;
		}

		return true;
	}

	public static long getNumberFromDigits(int[] digits) {
		long number = 0;

		for (int i = 0; i < digits.length; i++) {
			number = number * 10 + digits[i];
		}

		return number;
	}

	public static long getNumberFromDigits(int[] digits, int index, int length) {
		long number = 0;

		int i = index, j = 0;

		while (i < digits.length && j < length) {
			number = number * 10 + digits[i];
			i++;
			j++;
		}

		return number;
	}

	public static long combination(int n, int k) {
		if (k < n / 2) {
			k = n - k;
		}

		long result = 1;

		for (int i = k + 1, j = 1; i <= n; i++, j++) {
			result = result * i / j;
		}

		return result;
	}
}
