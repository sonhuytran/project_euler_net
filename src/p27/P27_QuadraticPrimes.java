/**
 * 
 */
package p27;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P27_QuadraticPrimes {

	/**
	 * 
	 */
	public P27_QuadraticPrimes() {
		// TODO Auto-generated constructor stub
	}

	private static Integer[] generatePrimes(int max) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		results.add(2);

		for (int i = 3; i <= max; i++) {
			double sqrt = Math.sqrt(i);
			boolean isPrime = true;

			for (int j = 0; results.get(j) <= sqrt; j++) {
				if (i % results.get(j) == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				results.add(i);
			}
		}

		Integer[] resultsArray = new Integer[results.size()];
		return results.toArray(resultsArray);
	}

	private static boolean isPrime(int number, Integer[] primes) {
		// binary search
		int position = Arrays.binarySearch(primes, number);
		return position >= 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] primes = generatePrimes(500000);
		int maxSequenceLength = 0;
		int maxProduct = 1;

		for (int i = 0; primes[i] < 1000; i++) {
			int b = primes[i];

			for (int j = 0; primes[j] <= 2001; j++) {
				int a = primes[j] - b - 1;
				int n = 0, value = b;

				do {
					n++;
					value = n * n + n * a + b;
				} while (isPrime(value, primes));

				if (n > maxSequenceLength) {
					maxSequenceLength = n;
					maxProduct = a * b;
				}
			}
		}

		System.out.println(maxProduct);
	}
}