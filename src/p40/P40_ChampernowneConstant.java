/**
 * 
 */
package p40;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P40_ChampernowneConstant {

	public static void main(String[] args) {
		StringBuilder stringBuilder = new StringBuilder();
		int i = 1;

		while (stringBuilder.length() < 1000000) {
			stringBuilder.append(i++);
		}

		int product = 1;

		for (int j = 1; j <= 1000000; j *= 10) {
			String c = stringBuilder.substring(j - 1, j);
			product *= Short.parseShort(c);
		}
		
		System.out.println(product);
	}
}