/**
 * 
 */
package p50;

import peutils.Primes;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P50_ConsecutivePrimeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Generate all the primes below 1,000,000
		int primesLength = 78498;

		Primes primes = new Primes(primesLength);
		int[] primeNumbers = primes.getPrimes();

		System.out.println(primeNumbers[primesLength]);

		int chainLength = 1000;

		// iterate the chainLength
		while (chainLength > 1) {
			int currentSum = -1;

			for (int i = primesLength - chainLength; i >= 1; i--) {
				if (currentSum == -1) {
					// get the first sum
					int sum = 0, end = i + chainLength - 1;

					for (int j = i; j <= end; j++) {
						sum += primeNumbers[j];
					}

					currentSum = sum;
				} else {
					// the next sum
					currentSum -= primeNumbers[i + chainLength];
					currentSum += primeNumbers[i];
				}

				if (currentSum < 1000000 && primes.isPrimeNumber(currentSum)) {
					String result = String.format(
							"%d : prime[%d]=%d to prime[%d]=%d", currentSum, i,
							primeNumbers[i], i + chainLength - 1,
							primeNumbers[i + chainLength - 1]);
					System.out.println(result);

					return;
				}
			}

			chainLength--;
		}
	}
}
