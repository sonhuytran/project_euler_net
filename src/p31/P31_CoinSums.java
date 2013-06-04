/**
 * 
 */
package p31;

import java.util.Arrays;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P31_CoinSums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };
		int[] combinations = new int[201];
		
		combinations[0] = 1;

		for (int i = 0; i < coins.length; i++) {
			int coinValue = coins[i];

			for (int j = coinValue; j < combinations.length; j++) {
				combinations[j] += combinations[j - coinValue];
			}
			
			// System.out.println(Arrays.toString(combinations));
		}

		System.out.println(combinations[200]);
	}
}
