/**
 * 
 */
package p45;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P45_TriangularPentagonalHexagonal {

	private static int[] generateTriangulars() {
		int[] triangulars = new int[100000];

		for (int i = 1; i <= triangulars.length; i++) {
			if (i % 2 == 0) {
				triangulars[i - 1] = (i / 2) * (i + 1);
			} else {
				triangulars[i - 1] = i * ((i + 1) / 2);
			}
		}

		return triangulars;
	}

	private static int[] generatePentagonals() {
		int[] pentagonals = new int[100000];

		for (int i = 1; i <= pentagonals.length; i++) {
			if (i % 2 == 0) {
				pentagonals[i - 1] = (i / 2) * (3 * i - 1);
			} else {
				pentagonals[i - 1] = i * ((3 * i - 1) / 2);
			}
		}

		return pentagonals;
	}

	private static int[] generateHexagonals() {
		int[] hexagonals = new int[100000];

		for (int i = 1; i <= hexagonals.length; i++) {
			hexagonals[i - 1] = i * (2 * i - 1);
		}

		return hexagonals;
	}

	private static int findNext(int[] array1, int[] array2, int[] array3,
			int index) {
		int i = index, j = 0, k = 0;

		while (i < array1.length) {
			while (j < array2.length && array2[j] < array1[i]) {
				j++;
			}

			if (j >= array2.length) {
				return -1;
			}

			if (array2[j] > array1[i]) {
				if (j > 0) {
					j--;
				}

				i++;
				continue;
			} else {
				// array2[j] == array1[i]
				while (k < array3.length && array3[k] < array1[i]) {
					k++;
				}

				if (k >= array3.length) {
					return -1;
				}

				if (array3[k] > array1[i]) {
					if (k > 0) {
						k--;
					}

					i++;
					continue;
				} else {
					System.out.println(i);
					return array1[i];
				}
			}
		}

		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] triangulars = generateTriangulars();
		int[] pentagonals = generatePentagonals();
		int[] hexagonals = generateHexagonals();

		System.out.println(findNext(triangulars, pentagonals, hexagonals, 285));
	}
}
