/**
 * 
 */
package p28;

/**
 * @author LG
 * 
 */
public class P28_NumberSpiralDiagonals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size = 1;
		int maxSize = 1001;
		long sum = 1;
		int lastNumber = 1;

		while (size < maxSize) {
			int distance = size + 1;
			sum += (lastNumber * 4 + distance * 10);
			lastNumber = lastNumber + distance * 4;
			size += 2;
		}

		System.out.println(sum);
	}
}