/**
 * 
 */
package p72;

import peutils.Primes;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P27_CountingFractions {

	private static int[] primeNumbers = null;

	private static int phi(int number) {
		int i = 1;
		int phi = 1;

		while (i < primeNumbers.length && number > 1) {
			int prime = primeNumbers[i];
			int count = 0;

			while (number % prime == 0) {
				count++;
				number /= prime;
			}

			if (count > 0) {
				phi = phi * (prime - 1) * (int) Math.pow(prime, count - 1);
			}

			i++;
		}

		if (number > 1) {
			phi = phi * (number - 1);
		}

		return phi;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Primes primes = new Primes(10000);
		primeNumbers = primes.getPrimes();

		long sum = 0;

		for (int i = 2; i <= 1000000; i++) {
			sum += phi(i);
		}

		System.out.println(sum);
	}

}
