/**
 * 
 */
package p29;

import java.util.ArrayList;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P29_DistincePowers {

	private static Integer[] primes(int max) {
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

	private static int[] toPrimeProducts(Integer[] primes, int number) {
		int[] results = new int[primes.length];

		for (int i = 0; i < results.length; i++) {
			results[i] = 0;
		}

		int index = 0;

		while (number > 1) {
			if (number % primes[index] == 0) {
				number /= primes[index];
				results[index]++;
			} else {
				index++;
			}
		}

		return results;
	}

	private static int duplicate(int[][] grid) {
		int col = grid[0].length;
		boolean[] marks = new boolean[grid.length];

		for (int i = 0; i < marks.length; i++) {
			marks[i] = false;
		}

		for (int i = 0; i < grid.length - 1; i++) {
			if (marks[i]) {
				continue;
			}

			for (int j = i + 1; j < grid.length; j++) {
				if (marks[j]) {
					continue;
				}

				boolean isDup = true;

				for (int k = 0; k < col; k++) {
					if (grid[i][k] != grid[j][k]) {
						isDup = false;
						break;
					}
				}

				if (isDup) {
					marks[j] = true;
				}
			}
		}

		int dup = marks.length;

		for (int i = 0; i < marks.length; i++) {
			if (marks[i]) {
				dup--;
			}
		}

		return dup;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] primeNumbers = primes(100);
		int[][] grid = new int[99 * 99][primeNumbers.length];
		int index = 0;

		for (int i = 2; i <= 100; i++) {
			int[] primeProducts = toPrimeProducts(primeNumbers, i);

			for (int j = 2; j <= 100; j++) {
				for (int k = 0; k < primeProducts.length; k++) {
					grid[index][k] = primeProducts[k] * j;
				}

				index++;
			}
		}

		System.out.println(duplicate(grid));
	}
}