/**
 * 
 */
package p46;

import java.util.ArrayList;

/**
 * @author LG
 * 
 */
public class P46_GoldbachOtherConjecture {

	private static boolean isPrimes(int number, ArrayList<Integer> primes) {
		int sqrt = (int) Math.sqrt(number);
		int i = 0;

		while (primes.get(i) <= sqrt) {
			if (number % primes.get(i) == 0) {
				return false;
			}

			i++;
		}

		return true;
	}

	private static boolean isSquare(int number) {
		int sqrt = (int) Math.sqrt(number);

		return (sqrt * sqrt) == number;
	}

	private static boolean isGoldBach(int number, ArrayList<Integer> primes) {
		for (int i = 0; i < primes.size(); i++) {
			if (isSquare((number - primes.get(i)) / 2)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();

		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);

		int i = 9;

		while (isGoldBach(i, primes)) {
			i += 2;

			while (isPrimes(i, primes)) {
				primes.add(i);
				i += 2;
			}
		}

		System.out.println(i);
	}
}
