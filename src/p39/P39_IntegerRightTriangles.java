/**
 * 
 */
package p39;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P39_IntegerRightTriangles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] count = new int[1001];

		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}

		for (int a = 1; a < 334; a++) {
			for (int b = a; b < 501; b++) {
				int a2b2 = a * a + b * b;
				int c = (int) Math.sqrt(a * a + b * b);

				if ((c * c) == a2b2) {
					int p = a + b + c;

					if (p <= 1000) {
						count[p] = count[p] + 1;
					}
					
					if (p == 840) {
						System.out.println(a + " " + b + " " + c);
					}
				}
			}
		}

		int maxCount = 0, maxI = -1;

		for (int i = 0; i < count.length; i++) {
			if (count[i] > maxCount) {
				maxCount = count[i];
				maxI = i;
			}
		}
		
		System.out.println(maxCount + " " + maxI);
	}

}
