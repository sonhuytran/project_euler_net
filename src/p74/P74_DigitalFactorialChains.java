/**
 * 
 */
package p74;

import java.util.ArrayList;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P74_DigitalFactorialChains {

	private static int[] factorials;
	private static int[] nexts;

	private static int next(int number) {
		int result = 0;

		while (number > 0) {
			result += factorials[number % 10];
			number /= 10;
		}

		return result;
	}

	private static int[] generateNexts() {
		int[] results = new int[3000000];

		for (int i = 0; i < results.length; i++) {
			results[i] = next(i);
		}

		return results;
	}

	private static int getChain(int number) {
		int temp = number;
		ArrayList<Integer> steps = new ArrayList<Integer>(100);

		do {
			steps.add(temp);
			temp = nexts[temp];
		} while (!steps.contains(temp));

		return steps.size();
	}

	private static int[] getFactorials() {
		int[] factorials = new int[10];
		factorials[0] = 1;

		for (int i = 1; i < factorials.length; i++) {
			factorials[i] = factorials[i - 1] * i;
		}

		return factorials;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		factorials = getFactorials();
		nexts = generateNexts();
		int count = 0;

		for (int i = 1; i < 1000000; i++) {
			if (getChain(i) >= 60) {
				count++;
			}
		}

		System.out.println(count);
	}
}
