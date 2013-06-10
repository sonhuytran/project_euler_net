/**
 * 
 */
package p145;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P145_ReversibleNumbers {

	private static int reverse(int number) {
		int temp = 0;
		
		while (number > 0) {
			temp = temp * 10 + number % 10;
			number /= 10;
		}
		
		return temp;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 1; i <= 10000000; i++) {
			if (i % 10 == 0) {
				continue;
			}
			
			int reverseNumber = reverse(i);
		}
	}
}
