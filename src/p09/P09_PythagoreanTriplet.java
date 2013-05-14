/**
 * 
 */
package p09;

/**
 * @author mtpham
 * 
 */
public class P09_PythagoreanTriplet {

	/**
	 * 
	 */
	public P09_PythagoreanTriplet() {
		// TODO Auto-generated constructor stub
	}

	private static boolean isPythagoreanTriplet(int a, int b, int c) {
		if (a * a + b * b - c * c == 0) {
			return true;
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int a = 1; a < 333; a++) {
			for (int b = 0; b < (1000 - a) / 2; b++) {
				int c = 1000 - a - b;

				if (isPythagoreanTriplet(a, b, c)) {
					System.out.println(a * b * c);
					return;
				}
			}
		}
	}

}
