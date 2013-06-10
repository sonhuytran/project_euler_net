/**
 * 
 */
package p78;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P78_CoinPartitions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 5000;
		int[] numbers = new int[size + 1];
		BigInteger[] partitions = new BigInteger[size + 1];

		for (int i = 1; i <= size; i++) {
			numbers[i] = i;
			partitions[i] = BigInteger.valueOf(0);
		}

		partitions[0] = BigInteger.valueOf(1);

		for (int i = 1; i <= size; i++) {
			int value = numbers[i];

			for (int j = i; j <= size; j++) {
				partitions[j] = partitions[j].add(partitions[j - value]);
			}
		}

		// System.out.println(Arrays.toString(partitions));
		System.out.println(partitions[5]);

		BigInteger oneMillion = BigInteger.valueOf(1000000);

		int i = 0;

		while (i <= size
				&& !partitions[i].mod(oneMillion).equals(BigInteger.ZERO)) {
			i++;
		}

		if (i > size) {
			System.out.println("No solution");
		} else {
			System.out.println("Solution is : " + i);
		}
	}

}
