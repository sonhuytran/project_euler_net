/**
 * 
 */
package p81;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P81_PathSumTwoWays {

	private static int[][] input = null;

	private static void readInputs() throws IOException {
		input = new int[80][80];

		FileInputStream fis = new FileInputStream("bin\\p81\\matrix.txt");
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
			readInputs(); // read --> int[80][80] input;
			long[][] sumPath = new long[80][80];
			
			// the bottom-right cell
			sumPath[79][79] = input[79][79];

			// the most right column and the bottom line
			for (int i = 78; i >= 0; i--) {
				sumPath[79][i] = input[79][i] + sumPath[79][i + 1];
				sumPath[i][79] = input[i][79] + sumPath[i + 1][79];
			}

			// towards the first cell
			for (int i = 78; i >= 0; i--) {
				for (int j = 78; j >= 0; j--) {
					sumPath[i][j] = Math.min(sumPath[i + 1][j],
							sumPath[i][j + 1]) + input[i][j];
				}
			}

			System.out.println(sumPath[0][0]);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
