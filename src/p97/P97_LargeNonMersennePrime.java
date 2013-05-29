/**
 * 
 */
package p97;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P97_LargeNonMersennePrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long product = 1, mod = 10000000000L;

		for (int i = 1; i <= 7830457; i++) {
			product = product * 2 % mod;
		}

		long result = (product * 28433 + 1) % mod;
		System.out.println(result);
	}
}