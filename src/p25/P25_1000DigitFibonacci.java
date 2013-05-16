/**
 * 
 */
package p25;

/**
 * @author LG
 * 
 */
public class P25_1000DigitFibonacci {

	private static String sum(String number1, String number2) {
		if (number1.length() != number2.length()) {
			int nZero = Math.abs(number2.length() - number1.length());
			StringBuilder stringBuilder = new StringBuilder();

			for (int i = 0; i < nZero; i++) {
				stringBuilder.append("0");
			}

			if (number1.length() < number2.length()) {
				stringBuilder.append(number1);
				number1 = stringBuilder.toString();
			} else {
				stringBuilder.append(number2);
				number2 = stringBuilder.toString();
			}
		}

		StringBuilder resultBuilder = new StringBuilder();
		int remainder = 0, sum = 0;

		for (int i = number1.length() - 1; i >= 0; i--) {
			sum = remainder + Short.parseShort(number1.substring(i, i + 1))
					+ Short.parseShort(number2.substring(i, i + 1));
			resultBuilder.insert(0, sum % 10);
			remainder = sum / 10;
		}

		if (remainder > 0) {
			resultBuilder.insert(0, remainder);
		}

		return resultBuilder.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "1";
		String b = "1";
		String c = "2";
		int i = 3;
		
		while (c.length() < 1000) {
			a = b;
			b = c;
			c = sum(a, b);
			i++;
		}
		
		System.out.println(i);
	}
}
