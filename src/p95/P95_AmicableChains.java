/**
 * 
 */
package p95;

import java.util.ArrayList;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P95_AmicableChains {

	private static int sumOfProperDivisors(int number) {
		int sum = 1;
		int max = (int) Math.sqrt(number);

		for (int i = 2; i <= max; i++) {
			if (number % i == 0) {
				sum = sum + i + number / i;

				if (sum > 1000000) {
					return -1;
				}
			}
		}

		return sum;
	}

	private static int findChainLength(int[] sums, int number) {
		int start = number;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(number);

		do {
			start = sums[start];

			if (start == -1) {
				return -1;
			}

			if (list.contains(start)) {
				return list.size() - list.indexOf(start);
			}

			list.add(start);
		} while (true);
	}

	private static int minChainLength(int[] sums, int number) {
		int start = number;

		ArrayList<Integer> list = new ArrayList<>();
		list.add(number);

		do {
			start = sums[start];

			if (start == -1) {
				return -1;
			}

			if (list.contains(start)) {
				int min = Integer.MAX_VALUE;

				for (int i = list.indexOf(start); i < list.size(); i++) {
					if (list.get(i) < min) {
						min = list.get(i);
					}
				}

				return min;
			}

			list.add(start);
		} while (true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 1000000, maxChainLength = -1, iMax = -1;
		int[] properDivisorSums = new int[max + 1];

		for (int i = 1; i <= max; i++) {
			properDivisorSums[i] = sumOfProperDivisors(i);
		}

		for (int i = 1; i <= max; i++) {
			int chainLength = findChainLength(properDivisorSums, i);

			if (chainLength > maxChainLength) {
				maxChainLength = chainLength;
				iMax = i;
			}
		}

		System.out.println(minChainLength(properDivisorSums, iMax));
	}
}
