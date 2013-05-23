/**
 * 
 */
package p37;

import java.util.ArrayList;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P37_TruncatablePrimes {

	private static boolean isPrime(int number, ArrayList<Integer> primes) {
		int low = 0, high = primes.size() - 1, mid = (low + high) / 2;

		while (low <= high) {
			if (primes.get(mid) == number) {
				return true;
			} else if (primes.get(mid) > number) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
			
			mid = (low + high) / 2;
		}

		return false;
	}

	private static boolean isTruncatableLeft(int prime,
			ArrayList<Integer> primes) {
		int ten = 10;
		int temp = prime % ten;

		while (temp < prime) {
			if (!isPrime(temp, primes)) {
				return false;
			}

			ten *= 10;
			temp = prime % ten;
		}

		return true;
	}

	private static boolean isTruncatableRight(int prime,
			ArrayList<Integer> primes) {
		prime /= 10;
		
		while (prime > 0) {
			if (!isPrime(prime, primes)) {
				return false;
			}
			
			prime /= 10;
		}

		return true;
	}

	private static boolean isTruncatablePrime(int prime,
			ArrayList<Integer> primes) {
		if (isTruncatableLeft(prime, primes)
				&& isTruncatableRight(prime, primes)) {
			return true;
		}

		return false;
	}

	private static Integer[] generatePrimes(int max) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);

		for (int i = 3; i <= 10; i++) {
			double sqrt = Math.sqrt(i);
			boolean isPrime = true;

			for (int j = 0; primes.get(j) <= sqrt; j++) {
				if (i % primes.get(j) == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				primes.add(i);
			}
		}
		
		for (int i = 11; i <= max; i++) {
			double sqrt = Math.sqrt(i);
			boolean isPrime = true;

			for (int j = 0; primes.get(j) <= sqrt; j++) {
				if (i % primes.get(j) == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				primes.add(i);
				
				if (isTruncatablePrime(i, primes)) {
					System.out.println(i);
					result.add(i);
				}
			}
		}

		Integer[] resultsArray = new Integer[result.size()];
		return result.toArray(resultsArray);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] truncatablePrimes = generatePrimes(1000000);
		long sum = 0;
		
		for (int i = 0; i < truncatablePrimes.length; i++) {
			sum += truncatablePrimes[i];
		}
		
		System.out.println(sum);
	}

}
