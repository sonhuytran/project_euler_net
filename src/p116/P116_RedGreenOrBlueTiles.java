/**
 * 
 */
package p116;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P116_RedGreenOrBlueTiles {

	private static long combinations(int n, int k) {
		// make sure that k < n / 2
		if (k > n / 2) {
			k = n - k;
		}

		long result = 1;

		for (int i = 1, j = n - k + 1; i <= k; i++, j++) {
			result = result * j / i;
		}

		return result;
	}

	private static long countWay(int length, int value) {
		int i = 1;
		long count = 0;

		while (i * value <= length) {
			int coloured = i;
			int black = length - i * value;
			count += combinations(coloured + black, coloured);

			i++;
		}

		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = 50;
		int[] values = { 2, 3, 4 };
		long count = 0;

		for (int i = 0; i < values.length; i++) {
			int value = values[i];
			count += countWay(length, value);
		}
		
		System.out.println(count);
	}
}