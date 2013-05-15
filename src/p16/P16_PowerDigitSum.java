/**
 * 
 */
package p16;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P16_PowerDigitSum {

	private static String doubleOf(String number) {
		StringBuilder resultBuilder = new StringBuilder();

		int remainder = 0;
		int product = 1;

		for (int index = number.length() - 1; index >= 0; index--) {
			int i = Integer.parseInt(number.substring(index, index + 1));
			product = remainder + i * 2;
			resultBuilder.insert(0, product % 10);
			remainder = product / 10;
		}

		if (remainder > 0) {
			resultBuilder.insert(0, remainder);
		}

		return resultBuilder.toString();
	}

	private static String twoPower(int expo) {
		String number = "1";

		for (int i = 0; i < 1000; i++) {
			number = doubleOf(number);
		}

		return number;
	}

	private static long sumDigit(String number) {
		long sum = 0;

		for (int i = number.length() - 1; i >= 0; i--) {
			sum += Short.parseShort(number.substring(i, i + 1));
		}

		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(sumDigit(twoPower(1000)));
	}
}
