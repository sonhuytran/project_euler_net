/**
 * 
 */
package p187;

import peutils.Primes;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P187_SemiPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxPrime = 3100000;
		long max = 100000000;
		long sqrtMax = (int) Math.sqrt(max);
		Primes primes = new Primes(maxPrime);
		int[] primeNumbers = primes.getPrimes();

		int count = 0;

		for (int i = 1; i <= maxPrime; i++) {
			int firstPrime = primeNumbers[i];

			if (firstPrime > sqrtMax) {
				break;
			}

			int secondPrimeMax = (int) (max / firstPrime);
			int j = i;

			while (primeNumbers[j] <= secondPrimeMax) {
				j++;
				count++;
			}
		}

		System.out.println(count);
	}
}
