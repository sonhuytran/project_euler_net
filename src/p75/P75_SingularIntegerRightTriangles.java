/**
 * 
 */
package p75;

import java.util.Arrays;

import peutils.Utils;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P75_SingularIntegerRightTriangles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxLength = 1500000;
		int[] triangles = new int[maxLength + 1];
		int maxM = (int) Math.sqrt(maxLength / 2);

		for (int m = 2; m <= maxM; m++) {
			for (int n = 1; n < m; n++) {
				if (((m + n) % 2) == 1 && Utils.largestCommonDivisor(m, n) == 1) {
					int a = m * m + n * n;
					int b = m * m - n * n;
					int c = 2 * m * n;
					int firstP = a + b + c, p = firstP;

					while (p <= maxLength) {
						triangles[p]++;
						p += firstP;
					}
				}
			}
		}

		int count = 0;

		for (int i = 0; i < triangles.length; i++) {
			if (triangles[i] == 1) {
				count++;
			}
		}

		System.out.println(count);
	}
}
