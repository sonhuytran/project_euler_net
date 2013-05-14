/**
 * 
 */
package p10;

/**
 * @author mtpham
 * 
 */
public class P10_SummationOfPrimes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = 2000000;
		boolean[] isPrime = new boolean[N + 1];
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		double sqrt = Math.sqrt(N);

		for (int i = 2; i <= sqrt; i++) {
			if (isPrime[i]) {
				for (int j = i; i * j <= N; j++) {
					isPrime[i * j] = false;
				}
			}
		}

		long sum = 0;

		for (int i = 0; i < N; i++) {
			if (isPrime[i]) {
				sum += i;
			}
		}

		System.out.println(sum);
	}
}
