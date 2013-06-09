/**
 * 
 */
package p60;

import java.util.ArrayList;

import peutils.Primes;
import peutils.Utils;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P60_PrimePairsSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxPrimes = 3400;
		Primes primes = new Primes(maxPrimes);
		int[] primeNumbers = primes.getPrimes();
		ArrayList<Integer>[] concatPrimes = new ArrayList[maxPrimes + 1];

		System.out.println(primeNumbers[maxPrimes]);
		int count = 0;

		for (int i = 1; i <= maxPrimes; i++) {
			int prime1 = primeNumbers[i];
			concatPrimes[i] = new ArrayList<Integer>();

			if (prime1 * 5 >= Integer.MAX_VALUE) {
				break;
			}

			for (int j = i + 1; j <= maxPrimes; j++) {
				int prime2 = primeNumbers[j];

				if (prime1 + prime2 * 4 >= Integer.MAX_VALUE) {
					break;
				}

				int number1 = Utils.concat(prime1, prime2);
				int number2 = Utils.concat(prime2, prime1);

				if (primes.isPrimeNumber(number1)
						&& primes.isPrimeNumber(number2)) {
					count++;
					concatPrimes[i].add(j);
				}
			}
		}

		System.out.println(count);
	}
}
