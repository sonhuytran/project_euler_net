/**
 * 
 */
package p60;

import java.util.ArrayList;
import java.util.Iterator;

import peutils.Primes;

/**
 * @author LG
 * 
 */
public class P60_PrimePairsSet {

	private static int concat(int number1, int number2) {
		int temp = 0;

		while (number2 > 0) {
			temp = temp * 10 + number2 % 10;
			number2 /= 10;
		}

		while (temp > 0) {
			number1 = number1 * 10 + temp % 10;
			temp /= 10;
		}

		return number1;
	}

	private static boolean isPairs(Primes primes, int prime1, int prime2) {
		if (primes.isPrimeNumber(concat(prime1, prime2))
				&& primes.isPrimeNumber(concat(prime2, prime1))) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int primesLength = 10000;
		Primes primes = new Primes(primesLength);
		int[] primeNumbers = primes.getPrimes();
		System.out.println(primeNumbers[primesLength]);

		int prime1, prime2, prime3, prime4, count = 0;

		for (int i = 0; i < 2500; i++) {
			prime1 = primeNumbers[i];

			for (int j = i + 1; j < 2500; j++) {
				prime2 = primeNumbers[j];

				if (isPairs(primes, prime1, prime2)) {
					for (int j2 = j + 1; j2 < 2500; j2++) {
						prime3 = primeNumbers[j2];

						if (isPairs(primes, prime1, prime3)
								&& isPairs(primes, prime2, prime3)) {
							count++;
						}
					}
				}
			}
		}

		System.out.println(count);
	}
}
