/**
 * 
 */
package p36;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P36_DoubleBasePalindromes {

	private static int palindromeOf(int number, boolean usingMiddleDigit,
			int middleDigit) {
		int result = number, temp = number;

		if (usingMiddleDigit) {
			result *= 10;
			result += middleDigit;
		}

		while (temp > 0) {
			int digit = temp % 10;
			temp /= 10;
			result *= 10;
			result += digit;
		}

		return result;
	}

	private static TreeSet<Integer> base10Palindromes() {
		TreeSet<Integer> palindromes = new TreeSet<Integer>();

		for (int i = 0; i < 10; i++) {
			palindromes.add(i);
		}

		for (int i = 1; i < 99; i++) {
			palindromes.add(palindromeOf(i, false, 0));

			for (int j = 0; j < 10; j++) {
				palindromes.add(palindromeOf(i, true, j));
			}
		}

		for (int i = 100; i < 999; i++) {
			palindromes.add(palindromeOf(i, false, 0));
		}

		return palindromes;
	}

	private static boolean isBase2Palindrome(int number) {
		StringBuilder base2StringBuilder = new StringBuilder();
		int temp = number;

		while (temp > 0) {
			base2StringBuilder.insert(0, temp % 2);
			temp /= 2;
		}

		int length = base2StringBuilder.length();
		int halfLength = base2StringBuilder.length() / 2;

		for (int i = 0; i < halfLength; i++) {
			if (base2StringBuilder.charAt(i) != base2StringBuilder
					.charAt(length - 1 - i)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<Integer> palindromes = base10Palindromes();
		ArrayList<Integer> doubleBasePalindromes = new ArrayList<Integer>();

		for (Integer integer : palindromes) {
			if (isBase2Palindrome(integer)) {
				doubleBasePalindromes.add(integer);
			}
		}

		long sum = 0;

		for (Integer integer : doubleBasePalindromes) {
			sum += integer;
		}

		System.out.println(doubleBasePalindromes);
		System.out.println(sum);
	}
}