/**
 * 
 */
package p124;

import peutils.Primes;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P124_OrderedRadicals {

	private static long rad(Primes primes, int n) {
		if (primes.isPrimeNumber(n)) {
			return n;
		}

		int[] primeNumbers = primes.getPrimes();
		int result = 1, index = 1;

		while (n > 1) {
			int prime = primeNumbers[index];

			if (n % prime == 0) {
				do {
					n /= prime;
				} while (n % prime == 0);

				result *= prime;
			}

			index++;
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxPrime = 9592;
		int size = 100000;

		// calculate all the radicals
		Primes primes = new Primes(maxPrime);
		long[] numbers = new long[size + 1];
		long[] radicals = new long[size + 1];

		for (int i = 1; i <= size; i++) {
			numbers[i] = i;
			radicals[i] = rad(primes, i);
		}

		// insertion sorting
		for (int i = 1; i <= size - 1; i++) {
			for (int j = i + 1; j <= size; j++) {
				if (radicals[i] > radicals[j]) {
					// swap
					long temp = radicals[i];
					radicals[i] = radicals[j];
					radicals[j] = temp;

					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				} else if (radicals[i] == radicals[j]
						&& numbers[i] > numbers[j]) {
					long temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}

		System.out.println(numbers[10000]);
	}
}