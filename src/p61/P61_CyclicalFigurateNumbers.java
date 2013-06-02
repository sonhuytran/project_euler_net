/**
 * 
 */
package p61;

import java.util.Arrays;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P61_CyclicalFigurateNumbers {

	private static boolean findNext(int[][] polygonals, int[] cycle,
			int cycleLength, boolean[] mark) {
		if (cycleLength == 6) {
			if (cycle[5] % 100 == cycle[0] / 100) {
				System.out.println(Arrays.toString(cycle));

				int sum = 0;

				for (int i = 0; i < cycle.length; i++) {
					sum += cycle[i];
				}
				
				System.out.println(sum);

				return true;
			}

			return false;
		}

		int temp = cycle[cycleLength - 1] % 100;

		for (int i = 0; i < mark.length; i++) {
			if (!mark[i]) {
				mark[i] = true;

				for (int j = 0; j < polygonals[i].length; j++) {
					if (polygonals[i][j] / 100 == temp) {
						cycle[cycleLength] = polygonals[i][j];
						boolean found = findNext(polygonals, cycle,
								cycleLength + 1, mark);

						if (found) {
							return true;
						}
					}
				}

				mark[i] = false;
			}
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] polygonals = new int[6][96];
		boolean[] mark = new boolean[6];
		int[] cycle = new int[6];

		for (int i = 0, j = 19; j <= 58; i++, j++) {
			polygonals[0][i] = j * (3 * j - 2);
		}

		for (int i = 0, j = 21; j <= 63; i++, j++) {
			polygonals[1][i] = j * (5 * j - 3) / 2;
		}

		for (int i = 0, j = 23; j <= 70; i++, j++) {
			polygonals[2][i] = j * (2 * j - 1);
		}

		for (int i = 0, j = 26; j <= 81; i++, j++) {
			polygonals[3][i] = j * (3 * j - 1) / 2;
		}

		for (int i = 0, j = 32; j <= 100; i++, j++) {
			polygonals[4][i] = j * j;
		}

		for (int i = 0, j = 45; j <= 140; i++, j++) {
			polygonals[5][i] = j * (j + 1) / 2;
		}

		mark[0] = true;

		for (int i = 0; i < polygonals[0].length; i++) {
			cycle[0] = polygonals[0][i];
			findNext(polygonals, cycle, 1, mark);
		}
	}
}
