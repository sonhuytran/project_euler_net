/**
 * 
 */
package p112;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P112_BouncyNumbers {

	private static boolean isIncreasingNumber(int number, boolean increasing) {
		boolean isNonBouncy = true;
		int previous = increasing ? 9 : 0;

		while (number > 0) {
			int temp = number % 10;

			if ((increasing && temp > previous) || !increasing
					&& temp < previous) {
				isNonBouncy = false;
				break;
			}

			previous = temp;
			number /= 10;
		}

		return isNonBouncy;
	}

	private static boolean isBouncy(int number) {
		return !(isIncreasingNumber(number, true) || isIncreasingNumber(number,
				false));

	}

	private static int countBouncy(int hundredNumber) {
		int bouncy = 100, increasing = 0, decreasing = 0;
		boolean isIncreasingHundred = false, isDecreasingHundred = false;

		if (isIncreasingNumber(hundredNumber, true)) {
			isIncreasingHundred = true;
			int last = hundredNumber % 10;

			for (int i = last; i <= 9; i++) {
				increasing += (10 - i);
			}
		}

		if (isIncreasingNumber(hundredNumber, false)) {
			isDecreasingHundred = true;
			int last = hundredNumber % 10;

			for (int i = last; i >= 0; i--) {
				decreasing += (i + 1);
			}
		}

		bouncy = bouncy - increasing - decreasing;

		if (isIncreasingHundred && isDecreasingHundred) {
			bouncy++;
		}

		return bouncy;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// from 000 to 099, there is not any bouncy number
		int n = 0, bouncy = 0, tempBouncy = 0;

		// iterating each 100 number
		while (tempBouncy < 99 * (n + 1)) {
			n++;
			bouncy += countBouncy(n);

			tempBouncy = bouncy;

			if (isBouncy(100 * (n + 1))) {
				tempBouncy++;
			}
		}

		System.out.println(100 * (n + 1));
	}
}
