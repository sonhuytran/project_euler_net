/**
 * 
 */
package p38;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author LG
 * 
 */
public class P38_PandigitalMultiples {

	private static int checkStatus(int product, int[] digits) {
		while (product > 0) {
			int digit = product % 10;

			if (digit == 0) {
				return 1;
			}

			digits[digit]++;

			if (digits[digit] > 1) {
				return 1;
			}

			product /= 10;
		}

		for (int i = 1; i < digits.length; i++) {
			if (digits[i] < 1) {
				return -1;
			}
		}

		return 0;
	}

	private static int[] initializeDigits() {
		int digits[] = new int[10];

		for (int i = 0; i < digits.length; i++) {
			digits[i] = 0;
		}

		return digits;
	}

	private static int concat(ArrayList<Integer> integers) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < integers.size(); i++) {
			stringBuilder.append(integers.get(i));
		}

		return Integer.parseInt(stringBuilder.toString());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = -1;

		for (int i = 1; i < 10000; i++) {
			int j = 1, product = i * j, status = 0;
			int[] digits = initializeDigits();

			ArrayList<Integer> products = new ArrayList<Integer>();
			products.add(product);

			while ((status = checkStatus(product, digits)) < 0) {
				j++;
				product = i * j;
				products.add(product);
			}

			if (status == 0) {
				int pandigital = concat(products);

				if (pandigital > max) {
					max = pandigital;
				}
			}
		}

		System.out.println(max);
	}
}
