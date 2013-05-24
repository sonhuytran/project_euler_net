/**
 * 
 */
package p53;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P53_CombinatoricSelections {

	private static long c(int n, int k) {
		long result = 1, nminusk = n - k;

		for (int i = k + 1, j = 1; i <= n && j <= nminusk; i++, j++) {
			result *= i;
			result /= j;
		}

		return result;
	}

	private static int count(int n) {
		int halfN = n / 2;

		int k = n - 1;

		while (k >= halfN && c(n, k) < 1000000) {
			k--;
		}

		if (k < halfN) {
			return 0;
		}

		return k - (n - k) + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;

		for (int i = 1; i <= 100; i++) {
			sum += count(i);
		}

		System.out.println(sum);
	}
}
