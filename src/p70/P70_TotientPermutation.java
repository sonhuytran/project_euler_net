/**
 * 
 */
package p70;

import peutils.Primes;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P70_TotientPermutation {

	private static int[] primeNumbers = null;

	private static boolean isPermutation(int number1, int number2) {
		int[] digits = new int[10];
		int last1, last2;

		while (number1 > 0 && number2 > 0) {
			last1 = number1 % 10;
			number1 /= 10;
			digits[last1]++;

			last2 = number2 % 10;
			number2 /= 10;
			digits[last2]--;
		}

		if (number1 > 0 || number2 > 0) {
			return false;
		}

		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 0) {
				return false;
			}
		}

		return true;
	}

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
				// phi = phi * (prime - 1) * (int) Math.pow(prime, count - 1);
				phi = phi * (prime - 1);

				for (int j = 1; j <= count - 1; j++) {
					phi *= prime;
				}
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

		double min = Double.MAX_VALUE;
		int imin = -1;

		for (int i = 2; i < 10000000; i++) {
			if (primes.isPrimeNumber(i)) {
				continue;
			}

			int phi = phi(i);

			if (isPermutation(i, phi)) {
				double current = i * 1.0 / phi;

				if (current < min) {
					min = current;
					imin = i;
				}
			}

			if (i % 100000 == 0) {
				System.out.println(i);
			}
		}

		System.out.println(imin + " = " + min);
		System.out.println(phi(imin));
	}

}
