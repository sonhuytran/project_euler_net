/**
 * 
 */
package p42;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P42_CodedTriangleNumbers {

	private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private static ArrayList<String> readInputs(String fileName)
			throws NumberFormatException, IOException {

		ArrayList<String> grid = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader in = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(in);

		String buffer = null;

		// read the inputs
		while ((buffer = br.readLine()) != null) {
			String[] tokens = buffer.split(",");

			if (tokens.length > 0) {
				for (String token : tokens) {
					token.replace("\"", "");
					grid.add(token);
				}
			}
		}

		br.close();
		in.close();
		fis.close();

		return grid;
	}

	private static int[] generateTriangleNumbers() {
		int[] triangles = new int[50];

		for (int i = 0; i < triangles.length; i++) {
			triangles[i] = (i + 1) * (i + 2) / 2;
		}

		return triangles;
	}

	private static int sumChars(String words) {
		int sum = 0;

		for (int i = 0; i < words.length(); i++) {
			char c = words.charAt(i);
			sum += alphabet.indexOf(c) + 1;
		}

		return sum;
	}

	private static boolean isTriangle(int num, int[] triangles) {
		int a = 0, b = triangles.length - 1;

		while (a <= b) {
			int mid = (b - a / 2);

			if (triangles[mid] == num) {
				return true;
			} else if (triangles[mid] > num) {
				b = mid - 1;
			} else {
				a = mid + 1;
			}
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ArrayList<String> words = readInputs("bin\\p42\\words.txt");
			int[] triangles = generateTriangleNumbers();
			int count = 0;

			for (String word : words) {
				int sum = sumChars(word);

				if (isTriangle(sum, triangles)) {
					count++;
				}
			}

			System.out.println(count);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
