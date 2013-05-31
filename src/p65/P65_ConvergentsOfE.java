/**
 * 
 */
package p65;

import java.math.BigInteger;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P65_ConvergentsOfE {

	private static BigInteger numerator = BigInteger.valueOf(1);
	private static BigInteger denominator = BigInteger.valueOf(1);

	private static void inverse() {
		BigInteger temp = numerator;
		numerator = denominator;
		denominator = temp;
	}

	private static void add(int number) {
		numerator = numerator.add(denominator.multiply(BigInteger
				.valueOf(number)));
	}

	private static int sumDigits(BigInteger number) {
		String stringNumber = number.toString();
		int sum = 0;

		for (int i = 0; i < stringNumber.length(); i++) {
			sum += Integer.valueOf(stringNumber.substring(i, i + 1));
		}

		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int k = 66;

		add(k);
		inverse();
		add(1);
		inverse();

		for (k -= 2; k >= 2; k -= 2) {
			add(1);
			inverse();
			add(k);
			inverse();
			add(1);
			inverse();
		}

		add(2);

		System.out.println(numerator + "/" + denominator);
		System.out.println(sumDigits(numerator));
	}
}
