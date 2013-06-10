/**
 * 
 */
package p120;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P120_SquareRemainders {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int rSum = 0;

		for (int a = 3; a <= 1000; a++) {
			if (a % 2 == 0) {
				rSum += a * (a - 2);
			} else {
				rSum += a * (a - 1);
			}
		}

		System.out.println(rSum);
	}
}
