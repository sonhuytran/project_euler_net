/**
 * 
 */
package p66;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P66_DiophantineEquation {

	private static long findX(int d) {
		long y = 1, xSquare;

		do {
			xSquare = 1 + y * y * d;
			long x = (long) Math.sqrt(xSquare);

			if (x * x == xSquare) {
				return x;
			}

			y++;
		} while (true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxD = 1000;
		int result = 0;
		long x, maxX = -1;

		for (int d = 2; d <= maxD; d++) {
			x = findX(d);
			
			if (x > maxX) {
				maxX = x;
				result = d;
			}
		}
		
		System.out.println(result);
		System.out.println(maxX);
		
		System.out.println(findX(661));
	}
}
