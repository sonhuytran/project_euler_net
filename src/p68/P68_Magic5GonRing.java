/**
 * 
 */
package p68;

import peutils.Utils;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P68_Magic5GonRing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		long result = 0;

		do {
			// find the round which creates 16-digit number
			// i.e. the number 10 is external
			if (numbers[0] != 10 && numbers[1] != 10 && numbers[2] != 10
					&& numbers[3] != 10 && numbers[4] != 10) {
				int temp = numbers[0] + numbers[1] + numbers[6];

				// find the round
				if (temp == numbers[1] + numbers[2] + numbers[7]
						&& temp == numbers[2] + numbers[3] + numbers[8]
						&& temp == numbers[3] + numbers[4] + numbers[9]
						&& temp == numbers[4] + numbers[0] + numbers[5]) {

					// split into 5 arrangements
					int[][] arrangements = new int[][] {
							{ numbers[8], numbers[3], numbers[2] },
							{ numbers[7], numbers[2], numbers[1] },
							{ numbers[6], numbers[1], numbers[0] },
							{ numbers[5], numbers[0], numbers[4] },
							{ numbers[9], numbers[4], numbers[3] } };

					// find the arrangement with the minimum external number
					int min = 11, minI = -1;

					for (int i = 0; i < arrangements.length; i++) {
						if (arrangements[i][0] < min) {
							min = arrangements[i][0];
							minI = i;
						}
					}

					// Create the string number clockwise from the arrangement
					// with the minimum external number
					StringBuilder stringBuilder = new StringBuilder();

					for (int i = 0, j = minI; i < arrangements.length; i++, j = (j + 1) % 5) {
						String string = String.format("%d%d%d",
								arrangements[j][0], arrangements[j][1],
								arrangements[j][2]);
						stringBuilder.append(string);
					}

					String numberString = stringBuilder.toString();
					long number = Long.parseLong(numberString);

					// Check if it is the max
					if (number > result) {
						result = number;
					}
				}

			}
		} while (Utils.nextGeneration(numbers));

		System.out.println(result);
	}
}
