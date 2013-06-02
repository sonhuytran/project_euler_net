/**
 * 
 */
package p85;

import java.io.IOException;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P85_CountingRectangles {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int[][] count = new int[2001][2001];

		int nearest = 2000000, widthNearest = 0, heightNearest = 0;

		// width = 1
		for (int height = 1; height <= 2000; height++) {
			count[1][height] = height * (height + 1) / 2;
			int near = Math.abs(count[1][height] - 2000000);

			if (near < nearest) {
				nearest = near;
				widthNearest = 1;
				heightNearest = height;
			}
		}

		for (int width = 2; width <= 2000; width++) {
			for (int height = width; height <= 2000; height++) {
				int oldCount = count[width - 1][height];

				if (oldCount > 2000000) {
					continue;
				}

				for (int i = 0; i < height; i++) {
					oldCount += width * (height - i);
				}

				count[width][height] = oldCount;
				int near = Math.abs(oldCount - 2000000);

				if (near < nearest) {
					nearest = near;
					widthNearest = width;
					heightNearest = height;
				}
			}
		}

		String formatString = "%d x %d = %d (%d)";
		String resultString = String.format(formatString, widthNearest,
				heightNearest, widthNearest * heightNearest,
				count[widthNearest][heightNearest]);
		System.out.println(resultString);
	}
}
