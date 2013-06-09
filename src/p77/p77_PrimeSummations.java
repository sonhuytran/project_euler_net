/**
 * 
 */
package p77;

import peutils.Primes;

/**
 * @author Son-Huy TRAN
 * 
 */
public class p77_PrimeSummations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Primes primes = new Primes(30);
		int[] primeNumbers = primes.getPrimes();
		int[] combinations = new int[80];

		combinations[0] = 1;

		for (int i = 1; i < primeNumbers.length; i++) {
			int coinValue = primeNumbers[i];

			for (int j = coinValue; j < combinations.length; j++) {
				combinations[j] += combinations[j - coinValue];
			}
		}

		int i = 0;

		while (combinations[i] < 5000) {
			i++;
		}

		System.out.println(i);
	}

}
