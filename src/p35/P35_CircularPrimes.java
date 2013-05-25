/**
 * 
 */
package p35;

import java.util.ArrayList;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P35_CircularPrimes {

	private static ArrayList<Integer> primes(int max) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		results.add(2);

		for (int i = 3; i <= max; i += 2) {
			double sqrt = Math.sqrt(i);
			boolean isPrime = true;

			for (int j = 0; results.get(j) <= sqrt; j++) {
				if (i % results.get(j) == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				results.add(i);
			}
		}

		return results;
	}

	private static ArrayList<Integer> getAllCircularNumber(Integer number) {
		ArrayList<Short> digits = new ArrayList<Short>();
		ArrayList<Integer> results = new ArrayList<Integer>();

		while (number > 0) {
			Short digit = (short) (number % 10);
			digits.add(0, digit);
			number /= 10;
		}

		if (digits.size() > 1) {
			for (int i = 0; i < digits.size(); i++) {
				Short digit = digits.get(i);
				if (digit != 1 && digit != 3 && digit != 7 && digit != 9) {
					return results;
				}
			}
		}

		for (int i = 0; i < digits.size(); i++) {
			Integer newNumber = 0;

			for (int j = 0; j < digits.size(); j++) {
				newNumber = newNumber * 10
						+ digits.get((i + j) % digits.size());
			}

			results.add(newNumber);
		}

		return results;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> primes = primes(1000000);
		boolean[] marks = new boolean[primes.size()];

		for (int i = 0; i < marks.length; i++) {
			marks[i] = false;
		}

		for (int i = 0; i < primes.size(); i++) {
			if (marks[i]) {
				continue;
			}

			ArrayList<Integer> allCirculars = getAllCircularNumber(primes
					.get(i));
			boolean isCircularPrimes = true;

			for (Integer integer : allCirculars) {
				if (!primes.contains(integer)) {
					isCircularPrimes = false;
					break;
				}
			}

			if (isCircularPrimes) {
				for (Integer integer : allCirculars) {
					int index = primes.indexOf(integer);
					marks[index] = true;
				}
			}
		}

		int sum = 0;

		for (int i = 0; i < marks.length; i++) {
			if (marks[i]) {
				System.out.print(primes.get(i) + " ");
				sum++;
			}
		}

		System.out.println();
		System.out.println(sum);
	}
}
