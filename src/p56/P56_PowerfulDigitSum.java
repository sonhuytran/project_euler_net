/**
 * 
 */
package p56;

import java.math.BigInteger;

/**
 * @author LG
 * 
 */
public class P56_PowerfulDigitSum {

	private static int digitSum(BigInteger number) {
		String stringNumber = number.toString();
		int result = 0;

		for (int i = 0; i < stringNumber.length(); i++) {
			result += Integer.parseInt(stringNumber.substring(i, i + 1));
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = -1;

		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				BigInteger a = BigInteger.valueOf(i);

				// calculate a ^ b
				BigInteger pow = a.pow(j);
				int sum = digitSum(pow);

				if (sum > max) {
					max = sum;
				}
			}
		}

		System.out.println(max);
	}
}
