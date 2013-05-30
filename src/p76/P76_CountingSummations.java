/**
 * 
 */
package p76;

import java.util.Arrays;

/**
 * @author LG
 * 
 */
public class P76_CountingSummations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = new int[100];
		int[] sumCount = new int[101];

		for (int i = 0; i < 100; i++) {
			numbers[i] = i + 1;
		}

		sumCount[0] = 1;

		for (int i = 0; i < 100; i++) {
			for (int j = numbers[i]; j <= 100; j++) {
				sumCount[j] += sumCount[j - numbers[i]];
			}
		}

		for (int i = 0; i < sumCount.length; i++) {
			sumCount[i]--;
		}

		System.out.println(sumCount[100]);
		System.out.println(Arrays.toString(sumCount));
	}
}
