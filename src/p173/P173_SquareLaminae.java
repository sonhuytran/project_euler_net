/**
 * 
 */
package p173;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P173_SquareLaminae {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long maxTiles = 1000000;
		long maxSquares = maxTiles / 2 + 1;
		int sum = 0;

		for (long i = 3; i <= maxSquares; i++) {
			long j = i - 2;

			while (j > 0 && i * i - j * j <= maxTiles) {
				sum++;
				j -= 2;
			}
		}

		System.out.println(sum);
	}
}
