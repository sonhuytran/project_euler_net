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
		int max = 50000000;
		int maxPower4 = (int) Math.pow(max, 1.0 / 4);
		int maxPower3 = (int) Math.pow(max, 1.0 / 3);
		boolean[] expressible = new boolean[max + 1];

		for (int i = 1; primeNumbers[i] <= maxPower4; i++) {
			int prime4 = primeNumbers[i];
			int power4 = prime4 * prime4 * prime4 * prime4;

			for (int j = 1; primeNumbers[j] <= maxPower3; j++) {
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
