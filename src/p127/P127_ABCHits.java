package p127;

import peutils.Primes;
import peutils.Utils;

public class P127_ABCHits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxPrime = 11302;
		Primes p = new Primes(maxPrime);
		System.out.println(p.getPrimes()[maxPrime]);

		int count = 0;

		for (int i = 2; i < 60000; i++) {
			for (int j = i + 1; j < 120000 - i; j++) {
				if (Utils.largestCommonDivisor(i, j) == 1) {
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
