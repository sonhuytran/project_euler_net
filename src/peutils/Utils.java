/**
 * 
 */
package peutils;

/**
 * @author LG
 * 
 */
public class Utils {
	public static int largestCommonDivisor(int a, int b) {
		while (b > 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}

		return a;
	}
}
