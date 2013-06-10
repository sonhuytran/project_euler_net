/**
 * 
 */
package p123;

import peutils.Primes;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P123_PrimeSquareRemainders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create the first 22000 prime numbers
		Primes primes = new Primes(22000);
		int[] primeNumbers = primes.getPrimes();
		long max = 10000000000L, remainder = 0;

		int i = -1;

		while (remainder < max) {
			i += 2; // n even will give remainder 2
			long prime = primeNumbers[i];
			long square = prime * prime;
			remainder = (2 * prime * i) % square;
		}

		System.out.println(i);
	}
}
