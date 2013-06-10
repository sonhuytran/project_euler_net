/**
 * 
 */
package p125;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P125_PalindromicSums {

	private static boolean isPalindrome(int number) {
		int copyNumber = number;
		int reverse = 0;

		while (copyNumber > 0) {
			reverse = reverse * 10 + copyNumber % 10;
			copyNumber /= 10;
		}

		return (reverse == number);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int squareLength = 7072;
		int maxLength = 669;
		int max = 100000000;
		int[] squares = new int[squareLength + 1];

		for (int i = 0; i <= squareLength; i++) {
			squares[i] = i * i;
		}

		TreeSet<Integer> palindromes = new TreeSet<Integer>();

		for (int length = 2; length <= maxLength; length++) {
			// caculate the first sum
			int sum = 0;
			int i = 1;

			for (int j = i; j <= length; j++) {
				sum += squares[j];
			}

			// calculate the next sum
			while (sum < max) {
				if (isPalindrome(sum)) {
					palindromes.add(sum);
				}

				sum = sum - squares[i] + squares[length + i];
				i++;
			}
		}

		long palindromicSum = 0;

		for (Iterator<Integer> iterator = palindromes.iterator(); iterator
				.hasNext();) {
			Integer number = (Integer) iterator.next();
			palindromicSum += number;
		}

		System.out.println(palindromicSum);
	}
}
