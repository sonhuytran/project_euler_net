/**
 * 
 */
package p26;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P26_ReciprocalCycles {

	private static int count(int number) {
		int[] remainders = new int[number];

		for (int i = 0; i < remainders.length; i++) {
			remainders[i] = 0;
		}

		int remainder = 1 % number;
		int count = 1;

		do {
			remainders[remainder] = count;
			remainder *= 10;
			remainder %= number;
			count++;
		} while (remainders[remainder] <= 0);

		return count - remainders[remainder];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxLength = 6, maxNumber = 7;

		for (int i = 2; i < 1000; i++) {
			if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
				continue;
			}
			
			int countLength = count(i);
			
			if (countLength > maxLength) {
				maxLength = countLength;
				maxNumber = i;
			}
		}

		System.out.println(maxNumber + "=" + maxLength);
	}
}
