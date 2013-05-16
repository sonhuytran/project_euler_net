/**
 * 
 */
package p48;

/**
 * @author LG
 * 
 */
public class P48_SelfPowers {

	private static String multiple(String number1, int number2) {
		if (number1.length() > 10) {
			number1 = number1.substring(number1.length() - 10);

			return multiple(number1, number2);
		}

		StringBuilder resultBuilder = new StringBuilder();
		int remainder = 0;
		int product = 1;

		for (int i = number1.length() - 1; i >= 0; i--) {
			product = remainder + number2
					* Short.parseShort(number1.substring(i, i + 1));
			resultBuilder.insert(0, product % 10);
			remainder = product / 10;
		}

		if (remainder > 0) {
			resultBuilder.insert(0, remainder);
		}

		if (resultBuilder.length() > 10) {
			return resultBuilder.substring(resultBuilder.length() - 10);
		}

		return resultBuilder.toString();
	}

	private static String selfPower(int number) {
		String numberString = String.valueOf(number);

		for (int i = 2; i <= number; i++) {
			numberString = multiple(numberString, number);
		}

		return numberString;
	}

	private static String sum10(String[] numbers) {
		StringBuilder resultBuilder = new StringBuilder();
		int remainder = 0, sum = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i].length() < 10) {
				StringBuilder numberBuilder = new StringBuilder();
				numberBuilder.append(numbers[i]);

				while (numberBuilder.length() < 10) {
					numberBuilder.insert(0, "0");
				}

				numbers[i] = numberBuilder.toString();
			} else {
				break;
			}
		}

		for (int i = 9; i >= 0; i--) {
			sum = remainder;

			for (int j = 0; j < numbers.length; j++) {
				sum += Short.parseShort(numbers[j].substring(i, i + 1));
			}

			resultBuilder.insert(0, sum % 10);
			remainder = sum / 10;
		}

		return resultBuilder.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] numbers = new String[1000];

		for (int i = 0; i < 1000; i++) {
			numbers[i] = selfPower(i + 1);
			// System.out.println(numbers[i]);
		}

		System.out.println(sum10(numbers));
	}

}
