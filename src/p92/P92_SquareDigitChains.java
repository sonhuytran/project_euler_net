/**
 * 
 */
package p92;

/**
 * @author LG
 * 
 */
public class P92_SquareDigitChains {

	private static int next(int number) {
		int result = 0;

		while (number > 0) {
			int temp = number % 10;
			result += (temp * temp);
			number /= 10;
		}

		return result;
	}

	private static int getLast(int number) {
		do {
			number = next(number);
		} while (number != 1 && number != 89);

		return number;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] last = new int[701];

		// the first next can not be greater than 700
		// so first calculate the first 700 number
		for (int i = 1; i <= 700; i++) {
			int newlast = getLast(i);

			if (newlast == 89) {
				last[i]++;
			}
		}

		// calculate the lasts
		for (int i = 701; i < 10000000; i++) {
			int newNext = next(i);

			// if it ends up to 89
			if (last[newNext] > 0) {
				last[newNext]++;
			}
		}

		int count = 0;

		for (int i = 0; i < last.length; i++) {
			count += last[i];
		}

		System.out.println(count);
	}
}
