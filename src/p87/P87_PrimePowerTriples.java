/**
 * 
 */
package p87;

import peutils.Primes;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P87_PrimePowerTriples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Primes primes = new Primes(909);
		int[] primeNumbers = primes.getPrimes();
		boolean[] expressible = new boolean[50000000];

		// Set<Integer> numbers = new HashSet<Integer>(1139575);

		int max = 50000000;

		for (int i = 1; primeNumbers[i] <= 86; i++) {
			int prime4 = primeNumbers[i];
			int power4 = prime4 * prime4 * prime4 * prime4;

			for (int j = 1; primeNumbers[j] <= 368; j++) {
				int prime3 = primeNumbers[j];
				int sumPower43 = power4 + prime3 * prime3 * prime3;

				if (sumPower43 >= max) {
					continue;
				}

				int k = 1, number;
				int prime2 = primeNumbers[k];

				while ((number = sumPower43 + prime2 * prime2) <= max) {
					k++;
					prime2 = primeNumbers[k];
					expressible[number] = true;
				}
			}
		}

		int count = 0;

		for (int i = 0; i < expressible.length; i++) {
			if (expressible[i]) {
				count++;
			}
		}

		System.out.println(count);
	}
}
