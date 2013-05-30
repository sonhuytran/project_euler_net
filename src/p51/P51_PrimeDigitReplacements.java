/**
 * 
 */
package p51;

import peutils.Primes;

/**
 * @author LG
 * 
 */
public class P51_PrimeDigitReplacements {

	private static int test(Primes primesGenerator, int number, char c) {
		String numberString = String.valueOf(number);

		if (!numberString.contains(String.valueOf(c))) {
			return 0;
		}

		int count = 1;

		for (char ch = (char) (c + 1); ch <= '9'; ch++) {
			String newNumberString = numberString.replace(c, ch);

			if (primesGenerator.isPrimeNumber(Integer.valueOf(newNumberString))) {
				count++;
			}
		}

		if (count >= 8) {
			System.out.print(numberString + ";");

			for (char ch = (char) (c + 1); ch <= '9'; ch++) {
				String newNumberString = numberString.replace(c, ch);

				if (primesGenerator.isPrimeNumber(Integer
						.valueOf(newNumberString))) {
					System.out.print(newNumberString + ";");
					count++;
				}
			}
		}

		return count;
	}

	private static boolean isValid(int number) {
		while (number > 0) {
			int temp = number % 10;

			if (temp < 3) {
				return true;
			}

			number /= 10;
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int primesSize = 12000;
		Primes primesGenerator = new Primes(primesSize);
		int[] primeNumbers = primesGenerator.getPrimes();

		for (int i = 1; i <= primesSize; i++) {
			if (isValid(primeNumbers[i])) {
				for (char ch = '0'; ch <= '2'; ch++) {
					int testCount = test(primesGenerator, primeNumbers[i], ch);

					if (testCount == 8) {
						System.out.println(primeNumbers[i]);
						return;
					}
				}
			}
		}
	}
}
