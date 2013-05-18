/**
 * 
 */
package p34;

import java.util.ArrayList;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P34_DigitFactorials {

	private static int[] digitFactorials() {
		int[] result = new int[10];
		result[0] = result[1] = 1;
		int product = 1;

		for (int i = 2; i < 10; i++) {
			product *= i;
			result[i] = product;
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] factorials = digitFactorials();
		ArrayList<Long> curiousNumbers = new ArrayList<Long>();

		for (long i = 3; i < 10000000; i++) {
			long temp = i;
			long sum = 0;

			while (sum < i && temp > 0) {
				sum += factorials[(int) (temp % 10)];
				temp /= 10;
			}
			
			if (temp == 0 && sum == i) {
				curiousNumbers.add(i);
			}
		}
		
		System.out.println(curiousNumbers);
	}
}