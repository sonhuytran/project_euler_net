/**
 * 
 */
package p12;

/**
 * @author LG
 * 
 */
public class P12_HighlyDivisibleTriangularNumber {

	private static int divisorCount(long number) {
		int count = 0;
		int sqrt = (int) Math.sqrt(number);

		for (int i = 1; i <= sqrt; i++) {
			if (number % i == 0) {
				count += 2;
			}
		}
		// Correction if the number is a perfect square
		if (sqrt * sqrt == number) {
			count--;
		}

		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 1;
		long i = 1, number = 1;

		while (max < 500) {
			i++;
			number += i;
			max = divisorCount(number);
		}

		System.out.println(number);
	}
}
