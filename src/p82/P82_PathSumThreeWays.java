/**
 * 
 */
package p82;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P82_PathSumThreeWays {

	private static int[][] input = null;

	private static void readInputs() throws IOException {
		input = new int[80][80];

		FileInputStream fis = new FileInputStream("bin/p82/matrix.txt");
		InputStreamReader in = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(in);
		String line = null;
		int lineNumber = 0;

		while ((line = br.readLine()) != null && lineNumber < 80) {
			String[] tokens = line.split(",");

			for (int i = 0; i < tokens.length; i++) {
				input[lineNumber][i] = Integer.parseInt(tokens[i]);
			}

			lineNumber++;
		}

		br.close();
		in.close();
		fis.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int size = 80;
			readInputs();
			long[][] sumPath = new long[size][size];

			// the most right column
			for (int i = 0; i < size; i++) {
				sumPath[i][size - 1] = input[i][size - 1];
			}

			for (int j = size - 2; j >= 0; j--) {
				for (int i = 0; i < size; i++) {
					long temp = input[i][j];
					long min = temp + sumPath[i][j + 1];

					long tempup = temp;

					for (int k = i - 1; k >= 0; k--) {
						tempup += input[k][j];
						long currentUp = tempup + sumPath[k][j + 1];

						if (currentUp < min) {
							min = currentUp;
						}
					}

					long tempdown = temp;

					for (int k = i + 1; k < size; k++) {
						tempdown += input[k][j];
						long currentDown = tempdown + sumPath[k][j + 1];

						if (currentDown < min) {
							min = currentDown;
						}
					}

					sumPath[i][j] = min;
				}
			}

			long min = Long.MAX_VALUE;

			for (int i = 0; i < sumPath.length; i++) {
				System.out.println(Arrays.toString(sumPath[i]));

				if (sumPath[i][0] < min) {
					min = sumPath[i][0];
				}
			}

			System.out.println(min);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
