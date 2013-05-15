/**
 * 
 */
package p21;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P21_AmicableNumbers {

	private static int sumProperDivisor(int number) {
		if (number < 2) {
			return 0;
		}
		
		int sqrt = (int) Math.sqrt(number);
		int sum = 1;

		for (int i = 2; i < sqrt; i++) {
			if (number % i == 0) {
				sum += (i + number / i);
			}
		}

		if (sqrt * sqrt == number) {
			sum += sqrt;
		}

		return sum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 10000;
		int[] numbers = new int[N + 1];
		boolean[] marks = new boolean[N + 1];
		int sum = 0;

		for (int i = 1; i <= N; i++) {
			numbers[i] = sumProperDivisor(i);
			marks[i] = false;
		}

		for (int i = 1; i <= N; i++) {
			if (!marks[i] && numbers[i] <= N && numbers[i] != i
					&& i == numbers[numbers[i]]) {
				sum += (i + numbers[i]);
				marks[i] = marks[numbers[i]] = true;
				System.out.println(i + " " + numbers[i]);
			}
		}
		
		System.out.println(sum);
	}

}
