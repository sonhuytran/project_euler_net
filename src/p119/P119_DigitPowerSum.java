/**
 * 
 */
package p119;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P119_DigitPowerSum {

	private static int sumOfDigits(BigInteger number) {
		BigInteger zero = BigInteger.ZERO;
		BigInteger ten = BigInteger.valueOf(10);
		int result = 0;

		while (number.compareTo(zero) > 0) {
			result += number.mod(ten).shortValue();
			number = number.divide(ten);
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<BigInteger> set = new ArrayList<BigInteger>();

		for (int i = 2; i < 100; i++) {
			BigInteger value = BigInteger.valueOf(i);
			BigInteger power = BigInteger.valueOf(i);

			for (int exponent = 2; exponent < 20; exponent++) {
				power = power.multiply(value);

				if (sumOfDigits(power) == i) {
					set.add(power);
				}
			}
		}

		Collections.sort(set);
		System.out.println(set.get(29));
	}
}
