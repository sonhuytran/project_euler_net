/**
 * 
 */
package p49;

import peutils.Primes;

/**
 * @author LG
 * 
 */
public class P49_PrimePermutations {

	private static boolean isPermutations(int number1, int number2, int number3) {
		int[] digits = new int[10];
		int[] digitsTemp = new int[4];
		int index = 0;

		while (number1 > 0) {
			int temp = number1 % 10;
			digits[temp]++;
			digitsTemp[index++] = temp;
			number1 /= 10;
		}

		// check if number2 is a permutation of number1
		while (number2 > 0) {
			digits[(number2 % 10)]--;
			number2 /= 10;
		}

		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 0) {
				return false;
			}
		}

		// restore the digits
		for (int i = 0; i < digitsTemp.length; i++) {
			digits[digitsTemp[i]]++;
		}

		// check if number3 is a permutation of number1
		while (number3 > 0) {
			digits[(number3 % 10)]--;
			number3 /= 10;
		}

		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// get the primes under 1000
		Primes primes = new Primes(1229);
		int[] primeNumbers = primes.getPrimes();
		System.out.println(primeNumbers[1229]);

		// get the primes above 999
		int index = 0;

		while (primeNumbers[index] < 1000) {
			index++;
		}

		System.out.println(primeNumbers[index]);
		int count = 0;

		for (int i = index; i < primeNumbers.length - 1; i++) {
			for (int j = i + 1; j < primeNumbers.length; j++) {
				int prime1 = primeNumbers[i];
				int prime2 = primeNumbers[j];
				int prime3 = prime2 + (prime2 - prime1);

				if (prime3 < 10000 && primes.isPrimeNumber(prime3)
						&& isPermutations(prime1, prime2, prime3)) {
					System.out.println(prime1 + "" + prime2 + "" + prime3);
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
