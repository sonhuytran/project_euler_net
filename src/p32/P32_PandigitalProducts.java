/**
 * 
 */
package p32;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P32_PandigitalProducts {

	private static boolean isPandigital(long multiplicand, long multiplier,
			long product) {
		boolean[] digits = new boolean[10];

		while (multiplicand > 0) {
			int temp = (int) (multiplicand % 10);

			if (temp == 0) {
				return false;
			}

			if (digits[temp]) {
				return false;
			} else {
				digits[temp] = true;
			}

			multiplicand /= 10;
		}

		while (multiplier > 0) {
			int temp = (int) (multiplier % 10);

			if (temp == 0) {
				return false;
			}

			if (digits[temp]) {
				return false;
			} else {
				digits[temp] = true;
			}

			multiplier /= 10;
		}

		while (product > 0) {
			int temp = (int) (product % 10);

			if (temp == 0) {
				return false;
			}

			if (digits[temp]) {
				return false;
			} else {
				digits[temp] = true;
			}

			product /= 10;
		}

		for (int i = 1; i < digits.length; i++) {
			if (!digits[i]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long max = 987654321L;
		Set<Long> set = new HashSet<Long>();

		for (long i = 1; i < 10000; i++) {
			for (long j = i; j < 10000; j++) {
				long product = i * j;

				if (product > max) {
					break;
				}

				if (isPandigital(i, j, product)) {
					set.add(product);
					System.out.println(i + "*" + j + "=" + product);
				}
			}
		}

		int sum = 0;

		for (Long long1 : set) {
			sum += long1;
		}

		System.out.println(sum);
	}
}
