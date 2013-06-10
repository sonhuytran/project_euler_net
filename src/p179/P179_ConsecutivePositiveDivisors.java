/**
 * 
 */
package p179;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P179_ConsecutivePositiveDivisors {

	public static void main(String[] args) {
		int[] counts = new int[10000000];

		for (int i = 0; i < counts.length; i++) {
			counts[i] = 1; // every numbers are divisible by 1
		}

		int count = 0;

		for (int i = 2; i < counts.length; i++) {
			for (int j = i; j < counts.length; j += i) {
				counts[j]++; // increase the multiples of i
			}

			if (counts[i] == counts[i - 1]) {
				count++;
			}
		}

		System.out.println(count);
	}
}