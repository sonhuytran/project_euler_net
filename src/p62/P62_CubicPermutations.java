/**
 * 
 */
package p62;

import java.util.HashMap;
import java.util.TreeSet;

import peutils.Utils;

/**
 * @author LG
 * 
 */
public class P62_CubicPermutations {

	/**
	 * Greatest permutation is used to help store the permutations of the same
	 * digits. The greatest is used to avoid the leading zeros.
	 * 
	 * @param number
	 * @return
	 */
	private static long getGreatestPermutation(long number) {
		int[] digits = new int[20];
		int digitIndex = 0;

		while (number > 0) {
			digits[digitIndex++] = (int) (number % 10);
			number /= 10;
		}

		for (int i = 0; i < digitIndex - 1; i++) {
			for (int j = i + 1; j < digitIndex; j++) {
				if (digits[i] < digits[j]) {
					Utils.swap(digits, i, j);
				}
			}
		}

		return Utils.getNumberFromDigits(digits, 0, digitIndex);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Long, TreeSet<Long>> cubicsMap = new HashMap<Long, TreeSet<Long>>();
		boolean found = false;
		long i = 0;
		TreeSet<Long> foundSet = null;

		while (!found) {
			i++;
			Long number = (long) (i * i * i);
			Long smallestPermutation = getGreatestPermutation(number);

			TreeSet<Long> set = cubicsMap.get(smallestPermutation);

			if (set == null) {
				set = new TreeSet<Long>();
				cubicsMap.put(smallestPermutation, set);
			}

			set.add(i);

			if (set.size() >= 5) {
				found = true;
				foundSet = set;
			}
		}

		if (foundSet != null) {
			long foundI = foundSet.first();
			long number = foundI * foundI * foundI;
			System.out.println(String.format("%d = %d ^ 3", number, foundI));

			System.out.println(foundSet);
		}
	}
}
