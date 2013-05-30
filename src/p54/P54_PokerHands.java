/**
 * 
 */
package p54;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author LG
 * 
 */
public class P54_PokerHands {

	private static ArrayList<CardHand[]> readInputs(String fileName)
			throws IOException {
		ArrayList<CardHand[]> inputs = new ArrayList<CardHand[]>(1000);

		FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader in = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(in);

		String line = null;

		while ((line = br.readLine()) != null) {
			CardHand[] hands = CardHand.parse(line);
			inputs.add(hands);
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
		ArrayList<CardHand[]> inputs;

		try {
			inputs = readInputs("bin/p54/poker.txt");

			int count = 0;

			for (int i = 0; i < inputs.size(); i++) {
				CardHand[] hands = inputs.get(i);

				if (hands[0].greaterThan(hands[1])) {
					count++;
				}
			}

			System.out.println(count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
