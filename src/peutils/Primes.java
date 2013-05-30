/**
 * 
 */
package peutils;

/**
 * @author LG
 * 
 */
public class Primes {

	int[] primeNumbers;
	int nPrimes;

	public Primes(int n) {
		primeNumbers = new int[n + 1];
		primeNumbers[1] = 2;
		primeNumbers[2] = 3;
		nPrimes = 2;
		int p = 3;

		while (nPrimes < n) {
			p = primeNumbers[++nPrimes] = nextPrime(p);
		}
	}

	private int nextPrime(int p) {
		do {
			p += 2;
		} while (!isPrime(p));

		return p;
	}

	private boolean isPrime(int n) {
		int root = (int) Math.sqrt(n + 1);

		for (int i = 1; i < primeNumbers.length && primeNumbers[i] <= root; i++) {
			if (n % primeNumbers[i] == 0) {
				return false;
			}
		}

		return true;
	}

	public boolean isPrimeNumber(int number) {
		if (number > primeNumbers[nPrimes]) {
			return isPrime(number);
		}

		// binary search
		int low = 0, high = nPrimes;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (primeNumbers[mid] == number) {
				return true;
			} else if (primeNumbers[mid] > number) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return false;
	}

	public int[] getPrimes() {
		return primeNumbers;
	}
}
