/**
 * 
 */
package p30;

import java.util.ArrayList;

/**
 * @author LG
 * 
 */
public class P30_DigitFifthPower {

	private static int[] fifthPowers = generateFifthPowers();

	private static int[] generateFifthPowers() {
		int[] result = new int[10];
		result[0] = 0;
		result[1] = 1;

		for (int i = 2; i < 10; i++) {
			result[i] = (int) Math.pow(i, 5);
		}

		return result;
	}

	private static boolean isEqualFifthPowers(long number) {
		long temp = number, sum = 0;

		while (temp > 0) {
			sum += fifthPowers[(int) (temp % 10)];
			temp /= 10;
		}

		return sum == number;
	}

	private static long sumAll(ArrayList<Long> numbers) {
		long sum = 0;

		for (Long number : numbers) {
			sum += number;
		}

		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Long> equalFifthPowers = new ArrayList<Long>();

		for (long i = 2; i < 1000000; i++) {
			if (isEqualFifthPowers(i)) {
				equalFifthPowers.add(i);
				System.out.println(i);
			}
		}

		System.out.println(sumAll(equalFifthPowers));
	}

}
