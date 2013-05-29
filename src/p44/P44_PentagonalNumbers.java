/**
 * 
 */
package p44;

import java.util.Arrays;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P44_PentagonalNumbers {

	private static int[] generatePentagonal(int size) {
		int[] pentagonals = new int[size + 1];

		for (int i = 1; i <= size; i++) {
			pentagonals[i] = pentagonals[i - 1] + 1 + 3 * (i - 1);
		}

		return pentagonals;
	}

	private static boolean isPentagonal(int number) {
		int reverse = (int) ((Math.sqrt(24 * number + 1) + 1) / 6);
		return (reverse * (3 * reverse - 1)) / 2 == number;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = 3000;
		int[] pentagonals = generatePentagonal(length);
		System.out.println(Arrays.toString(pentagonals));

		for (int i = 2; i <= length; i++) {
			for (int j = i - 1; j >= 1; j--) {
				int pent1 = pentagonals[i];
				int pent2 = pentagonals[j];

				if (isPentagonal(pent1 - pent2) && isPentagonal(pent1 + pent2)) {
					System.out.println(pent1 - pent2);
				}
			}
		}
	}
}
