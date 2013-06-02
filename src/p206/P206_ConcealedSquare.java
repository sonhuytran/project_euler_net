/**
 * 
 */
package p206;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P206_ConcealedSquare {

	private static boolean test(long number) {
		for (long i = 9; i >= 1; i--) {
			if (number % 10 != i) {
				return false;
			}

			number /= 100;
		}

		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long found = 0;
		long i = 0;
		long from = (long) (Math.sqrt(10203040506070809L) / 10);
		long to = (long) (Math.sqrt(19293949596979899L) / 10) + 1;

		for (i = from; i <= to; i++) {
			long candidat = i * 10 + 3;

			if (test(candidat * candidat)) {
				found = candidat * 10;
				break;
			}

			candidat = i * 10 + 7;

			if (test(candidat * candidat)) {
				found = candidat * 10;
				break;
			}
		}

		System.out.println(found);
		System.out.println(found * found);
		System.out.println(test(i * i));
	}
}
