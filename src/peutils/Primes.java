/**
 * 
 */
package peutils;

/**
 * @author LG
 * 
 */
public class Primes {

	int[] primes;
	int nPrimes;

	public Primes(int n) {
		primes = new int[n + 1];
		primes[1] = 2;
		primes[2] = 3;
		nPrimes = 2;
		int p = 3;

		while (nPrimes < n) {
			p = primes[++nPrimes] = nextPrime(p);
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

		for (int i = 1; primes[i] <= root; i++) {
			if (n % primes[i] == 0) {
				return false;
			}
		}

		return true;
	}

	public boolean isPrimeNumber(int number) {
		if (number > primes[nPrimes]) {
			return isPrime(number);
		}

		// binary search
		int low = 0, high = nPrimes;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (primes[mid] == number) {
				return true;
			} else if (primes[mid] > number) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return false;
	}

	public int[] getPrimes() {
		return primes;
	}
}
