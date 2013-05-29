/**
 * 
 */
package p63;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P63_PowerfulDigitCounts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;

		for (int i = 1; i < 10; i++) {
			sum += (int) (1.0 / (1 - Math.log(i) / Math.log(10)));
		}

		System.out.println(sum);
	}
}
