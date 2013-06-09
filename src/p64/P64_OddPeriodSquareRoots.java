/**
 * 
 */
package p64;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P64_OddPeriodSquareRoots {

	private static int getContinuedFractionLength(int number) {
		int a0 = (int) Math.sqrt(number);

		if (a0 * a0 == number) {
			return 0;
		}

		int[] m = new int[300];
		int[] d = new int[300];
		int[] a = new int[300];

		m[0] = 0;
		d[0] = 1;
		a[0] = a0;
		int index = 0;

		do {
			index++;
			m[index] = d[index - 1] * a[index - 1] - m[index - 1];
			d[index] = (number - m[index] * m[index]) / d[index - 1];
			a[index] = (int) Math.floor((a0 + m[index]) * 1.0
					/ d[index]);

			int i = 0;

			while (i < index) {
				if (m[index] == m[i] && d[index] == d[i] && a[index] == a[i]) {
					return (index - i);
				} else {
					i++;
				}
			}
		} while (true);
	}

	private static int countOddPeriodSquareRoots(int max) {
		int count = 0;

		for (int i = 1; i <= max; i++) {
			int length = getContinuedFractionLength(i);

			if (length % 2 != 0) {
				count++;
			}
		}

		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countOddPeriodSquareRoots(10000));
	}

}
