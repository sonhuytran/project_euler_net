/**
 * 
 */
package p89;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P89_RomanNumerals {

	private static String[] readInputs(String fileName) throws IOException {
		String[] inputs = new String[1000];

		FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader in = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(in);

		String line = null;
		int index = 0;

		while ((line = br.readLine()) != null) {
			inputs[index++] = line;
		}

		br.close();
		in.close();
		fis.close();

		return inputs;
	}

	private static int newCharsSaved(String roman) {
		String best = roman.toString();

		best = best.replace("DCCCC", "CM");
		best = best.replace("CCCC", "CD");
		best = best.replace("LXXXX", "XC");
		best = best.replace("XXXX", "XL");
		best = best.replace("VIIII", "IX");
		best = best.replace("IIII", "IV");

		return roman.length() - best.length();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String[] inputs = readInputs("bin/p89/roman.txt");
			long sum = 0;

			for (int i = 0; i < inputs.length; i++) {
				sum += newCharsSaved(inputs[i]);
			}

			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
