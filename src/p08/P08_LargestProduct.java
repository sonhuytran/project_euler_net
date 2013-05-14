/**
 * 
 */
package p08;

import java.util.ArrayList;

/**
 * @author mtpham
 * 
 */
public class P08_LargestProduct {

	private ArrayList<Short> digits = null;

	/**
	 * 
	 */
	public P08_LargestProduct(String stringNumber) {
		if (stringNumber.length() < 5) {
			throw new IllegalArgumentException(
					"number must have at least 5 digits");
		}

		this.digits = new ArrayList<Short>();

		for (int i = 0; i < stringNumber.length(); i++) {
			String stringDigit = stringNumber.substring(i, i + 1);
			this.digits.add(Short.parseShort(stringDigit));
		}
	}

	public int getLargestProduct() {
		int maxProduct = -1;
		int maxSeriesIndex = -1;
		int currentProduct = 1;

		for (int i = 0; i < 5; i++) {
			currentProduct *= digits.get(i);
		}

		maxProduct = currentProduct;
		maxSeriesIndex = 0;

		for (int i = 5; i < digits.size(); i++) {
			int newProduct;

			if (digits.get(i) == 0) {
				newProduct = 0;
			} else if (digits.get(i - 5) == 0) {
				newProduct = 1;

				for (int j = i - 4; j <= i; j++) {
					newProduct *= digits.get(j);
				}
			} else {
				newProduct = currentProduct / digits.get(i - 5) * digits.get(i);
			}

			if (newProduct > maxProduct) {
				maxProduct = newProduct;
				maxSeriesIndex = i - 4;
			}

			currentProduct = newProduct;
		}
		
		System.out.println(maxSeriesIndex);
		
		for (int i = maxSeriesIndex; i < maxSeriesIndex + 5; i++) {
			
			System.out.print(this.digits.get(i) + " ");
		}
		
		System.out.println();

		return maxProduct;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String stringNumber = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		P08_LargestProduct p08_LargestProduct = new P08_LargestProduct(
				stringNumber);
		int largestProduct = p08_LargestProduct.getLargestProduct();
		System.out.print(largestProduct);
	}

}
