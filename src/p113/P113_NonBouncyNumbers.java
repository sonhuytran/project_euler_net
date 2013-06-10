/**
 * 
 */
package p113;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P113_NonBouncyNumbers {

	public static void main(String[] args) {
		// count increasing numbers
		int digit = 100;

		long[][] count = new long[10][digit];

		for (int i = 0; i < 10; i++) {
			count[i][digit - 1] = 10 - i;
		}

		for (int j = digit - 2; j >= 0; j--) {
			count[0][j] = 0;

			for (int i = 0; i < 10; i++) {
				count[0][j] += count[i][j + 1];
			}

			for (int i = 1; i < 10; i++) {
				count[i][j] = count[i - 1][j] - count[i - 1][j + 1];
			}
		}

		long sum = 0;

		for (int i = 0; i < 10; i++) {
			sum += count[i][1];
		}

		sum--;

		System.out.println(sum);

		// count decreasing numbers
		long[][] count2 = new long[10][digit];
		count2[0][digit - 1] = 10;

		for (int i = 1; i < 10; i++) {
			count2[i][digit - 1] = i + 1;
		}

		for (int j = digit - 2; j >= 0; j--) {
			count2[0][j] = 1;

			for (int i = 1; i < 10; i++) {
				count2[i][j] = count2[i - 1][j] + count2[i][j + 1];
			}
		}

		for (int j = digit - 2; j >= 0; j--) {
			count2[0][j] = count2[9][j] + count2[0][j + 1] - 1;
		}

		long sum2 = 0;

		for (int i = 0; i < 10; i++) {
			sum2 += count2[i][1];
		}

		sum2--;

		System.out.println(sum2);
		System.out.println(sum + sum2 - 9 * digit);
	}
}
