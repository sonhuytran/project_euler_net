package p24;

public class P24_LexicographicPermutations {

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	private static boolean next(int[] numbers) {
		int i = numbers.length - 2;
		boolean hasNext = false;

		while (i >= 0 && numbers[i] > numbers[i + 1]) {
			i--;
		}

		if (i >= 0) {
			hasNext = true;
			int j = numbers.length - 1;

			while (numbers[j] < numbers[i]) {
				j--;
			}

			swap(numbers, i, j);
			int a = i + 1, b = numbers.length - 1;

			while (a < b) {
				swap(numbers, a, b);
				a++;
				b--;
			}
		}

		return hasNext;
	}

	private static void print(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]);
		}
		
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int i = 1;

		while (i < 1000000) {
			i++;
			next(numbers);
		}
		
		print(numbers);
	}
}
