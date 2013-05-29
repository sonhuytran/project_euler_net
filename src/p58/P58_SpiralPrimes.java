package p58;

import peutils.Primes;

public class P58_SpiralPrimes {

	private static Primes primes = new Primes(10000);

	public static void main(String[] args) {
		int count = 0;
		int length = 3;

		do {
			int distance = length - 1;
			int start = length * length;
			int max = length * 2 - 1;

			for (int i = 0; i < 3; i++) {
				start -= distance;

				if (primes.isPrimeNumber(start)) {
					count++;
				}
			}

			if (10 * count < max) {
				break;
			}

			length += 2;
		} while (true);

		System.out.println(length);
	}
}