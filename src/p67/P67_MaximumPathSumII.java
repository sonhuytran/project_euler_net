/**
 * 
 */
package p67;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P67_MaximumPathSumII {

	private static ArrayList<int[]> readInputs(String fileName)
			throws NumberFormatException, IOException {
		ArrayList<int[]> grid = new ArrayList<int[]>();
		FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader in = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(in);
		String buffer = null;

		// read the inputs
		while ((buffer = br.readLine()) != null) {
			String[] tokens = buffer.split("\\s+");

			if (tokens.length > 0) {
				int[] lineNumbers = new int[tokens.length];
				int i = 0;

				for (String token : tokens) {
					int number = Integer.parseInt(token);
					lineNumbers[i++] = number;
				}

				grid.add(lineNumbers);
			}
		}

		br.close();
		in.close();
		fis.close();

		return grid;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ArrayList<int[]> numbers = readInputs("bin\\p67\\triangle.txt");
			ArrayList<int[]> costs = new ArrayList<>();

			// initializing : the first line costs is the last line number
			int[] lastLineNumbers = numbers.get(numbers.size() - 1);
			int[] firstLineCosts = new int[lastLineNumbers.length];

			for (int i = 0; i < lastLineNumbers.length; i++) {
				firstLineCosts[i] = lastLineNumbers[i];
			}

			costs.add(firstLineCosts);

			// iterating : each cost of the next line costs is the max
			// headlinecost[i] vs headlinecost[i+1]
			// added up with the current number
			for (int i = numbers.size() - 2; i >= 0; i--) {
				int[] currentLineNumbers = numbers.get(i);
				int length = currentLineNumbers.length;
				firstLineCosts = costs.get(0);
				int[] lineCosts = new int[length];

				for (int j = 0; j < length; j++) {
					lineCosts[j] = Math.max(firstLineCosts[j],
							firstLineCosts[j + 1]) + currentLineNumbers[j];
				}

				costs.add(0, lineCosts);
			}

			for (int i = 0; i < costs.size(); i++) {
				int[] costLine = costs.get(i);

				for (int j = 0; j < costLine.length; j++) {
					System.out.print(costLine[j] + " ");
				}

				System.out.println();
			}
		} catch (IOException | NumberFormatException e) {
			System.out.println("Can not read file");
			e.printStackTrace();
		}
	}
}