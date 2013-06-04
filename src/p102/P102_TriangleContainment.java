/**
 * 
 */
package p102;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P102_TriangleContainment {

	private static P102_Triangle[] readInputs(String fileName)
			throws IOException {
		P102_Triangle[] inputs = new P102_Triangle[1000];

		FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader in = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(in);

		String line = null;
		int index = 0;

		while ((line = br.readLine()) != null) {
			String[] strings = line.split(",");
			P102_Pointf a = new P102_Pointf(Float.parseFloat(strings[0]),
					Float.parseFloat(strings[1]));
			P102_Pointf b = new P102_Pointf(Float.parseFloat(strings[2]),
					Float.parseFloat(strings[3]));
			P102_Pointf c = new P102_Pointf(Float.parseFloat(strings[4]),
					Float.parseFloat(strings[5]));

			inputs[index++] = new P102_Triangle(a, b, c);
		}

		br.close();
		in.close();
		fis.close();

		return inputs;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			P102_Triangle[] inputs = readInputs("bin/p102/triangles.txt");
			P102_Pointf origin = new P102_Pointf(0, 0);

			int count = 0;

			for (int i = 0; i < inputs.length; i++) {
				P102_Triangle p102_Triangle = inputs[i];

				if (p102_Triangle.containsPoint(origin)) {
					count++;
				}
			}

			System.out.println(count);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
