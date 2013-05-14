/**
 * 
 */
package p07;

import java.util.ArrayList;

/**
 * @author mtpham
 * 
 */
public class P07_10001stPrime {
	private ArrayList<Integer> primes = null;

	/**
	 * 
	 */
	public P07_10001stPrime() {
		this.primes = new ArrayList<Integer>();
	}

	private boolean isPrime(Integer number) {
		boolean isPrimeNumber = true;
		double squareRoot = Math.sqrt(number);

		for (int i = 0; i < primes.size() && primes.get(i) <= squareRoot; i++) {
			if (number % primes.get(i) == 0) {
				isPrimeNumber = false;
				break;
			}
		}

		return isPrimeNumber;
	}

	public int getPrimeNumber(int order) {
		if (order <= 0) {
			throw new IllegalArgumentException("order >= 1");
		}

		if (order == 1) {
			return 2;
		}

		this.primes = new ArrayList<Integer>();
		this.primes.add(2);
		int i = 3;

		while (this.primes.size() < order) {
			if (this.isPrime(i)) {
				this.primes.add(i);
			}

			i += 2;
		}

		return this.primes.get(order - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		P07_10001stPrime p07_10001stPrime = new P07_10001stPrime();
		int prime10001 = p07_10001stPrime.getPrimeNumber(10001);
		System.out.print(prime10001);
	}
}
