/**
 * 
 */
package p23;

import java.util.ArrayList;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P23_NonAbundantSums {

	private static boolean isAbundantNumbers(int n) {
		int sum = 1;
		int sqrt = (int) Math.sqrt(n);

		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0) {
				if (i * i == n) {
					sum += i;
				} else {
					sum += (i + n / i);
				}

				if (sum > n) {
					return true;
				}
			}
		}

		return false;
	}

	private static ArrayList<Integer> getAbundantNumbers(int max) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 2; i < max; i++) {
			if (isAbundantNumbers(i)) {
				result.add(i);
			}
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> abundants = getAbundantNumbers(28123);
		System.out.println(abundants.size());
		boolean[] marks = new boolean[28124];

		for (int i = 0; i < marks.length; i++) {
			marks[i] = false;
		}

		for (int i = 0; i < abundants.size(); i++) {
			for (int j = 0; j < abundants.size(); j++) {
				int sumAbundants = abundants.get(i) + abundants.get(j);

				if (sumAbundants < 28124) {
					marks[sumAbundants] = true;
				}
			}
		}
		
		int sum = 0;

		for (int i = 0; i < marks.length; i++) {
			if (!marks[i])
				sum += i;
		}
		
		System.out.println(sum);
	}
}