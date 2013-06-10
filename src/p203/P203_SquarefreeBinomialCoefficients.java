/**
 * 
 */
package p203;

import java.util.TreeSet;

import peutils.Primes;
import peutils.Utils;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P203_SquarefreeBinomialCoefficients {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Generate Pascal numbers
		TreeSet<Long> pascalNumbers = new TreeSet<Long>();
		int maxPascalCoefficient = 50;

		for (int i = 0; i <= maxPascalCoefficient; i++) {
			int maxJ = (i % 2 == 0) ? (i / 2) : (i / 2 + 1);

			for (int j = 0; j <= maxJ; j++) {
				long c = Utils.combination(i, j);
				pascalNumbers.add(c);
			}
		}

		long maxPascal = pascalNumbers.last();
		long maxPrime = (long) Math.sqrt(maxPascal);

		System.out.println(maxPrime);
		int primeLength = 1015836;
		// int primeLength = 100;
		Primes primes = new Primes(primeLength);
		System.out.println(primes.getPrimes()[primeLength]);

		int[] primeNumbers = primes.getPrimes();
		long[] primeSquares = new long[primeLength + 1];

		for (int i = 1; i < primeSquares.length; i++) {
			long prime = primeNumbers[i];
			primeSquares[i] = prime * prime;
		}

		long sum = 0;

		for (long pascal : pascalNumbers) {
			int i = 1;

			while (pascal % primeSquares[i] != 0 && primeSquares[i] <= pascal) {
				i++;
			}

			if (primeSquares[i] > pascal) {
				sum += pascal;
			}
		}
		
		System.out.println(sum);
	}
}