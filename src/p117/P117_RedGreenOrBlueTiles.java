/**
 * 
 */
package p117;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P117_RedGreenOrBlueTiles {
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 50, blueVal = 4, greenVal = 3, redVal = 2;
		int blueMax = max / 4;
		long count = 0;

		for (int blue = 0; blue <= blueMax; blue++) {
			int rest1 = max - blue * blueVal;
			int greenMax = rest1 / 3;

			for (int green = 0; green <= greenMax; green++) {
				int rest2 = rest1 - green * greenVal;
				int redMax = rest2 / 2;

				for (int red = 0; red <= redMax; red++) {
					int black = rest2 - red * redVal;
					int nBlocks = blue + green + red + black;

					long countThisWay = combinations(nBlocks, blue)
							* combinations(nBlocks - blue, green)
							* combinations(nBlocks - blue - green, red);

					count += countThisWay;
				}
			}
		}

		System.out.println(count);
	}
}
