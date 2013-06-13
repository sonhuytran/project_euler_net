/**
 * 
 */
package p101;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P101_OptimumPolynomial {

	private static BigInteger calculateDelta(long[][] matrix) {
		if (matrix.length == 1) {
			return BigInteger.valueOf(matrix[0][0]);
		} else if (matrix.length == 2) {
			return BigInteger.valueOf(matrix[0][0] * matrix[1][1]
					- matrix[0][1] * matrix[1][0]);
		} else {
			int sign = 1;
			BigInteger sum = BigInteger.valueOf(0);

			for (int i = 0; i < matrix.length; i++) {
				long[][] matrixi = new long[matrix.length - 1][matrix.length];

				for (int j = 0; j < matrixi.length; j++) {
					for (int j2 = 0; j2 < matrixi.length; j2++) {
						if (j >= i) {
							matrixi[j][j2] = matrix[j + 1][j2 + 1];
						} else {
							matrixi[j][j2] = matrix[j][j2 + 1];
						}
					}
				}

				BigInteger delta = calculateDelta(matrixi);
				BigInteger value = delta.multiply(BigInteger
						.valueOf(matrix[i][0]));

				if (sign < 0) {
					value = value.negate();
				}

				sum = sum.add(value);

				sign = -sign;
			}

			return sum;
		}
	}

	private static void solveEquationSystem(long[][] equations,
			long[] coefficients) {
		// calculate delta
		long[][] matrix = new long[equations.length][equations.length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = equations[i][j];
			}
		}

		BigInteger delta = calculateDelta(matrix);

		for (int i = 0; i < coefficients.length; i++) {
			long[][] matrixi = new long[equations.length][equations.length];

			for (int j = 0; j < matrixi.length; j++) {
				for (int k = 0; k < matrixi.length; k++) {
					matrixi[j][k] = matrix[j][k];
				}
			}

			for (int j = 0; j < matrixi.length; j++) {
				matrixi[j][i] = equations[j][equations.length];
			}

			BigInteger deltai = calculateDelta(matrixi);
			coefficients[i] = deltai.divide(delta).longValue();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long[] trueCoefficients = new long[10];

		for (int i = 1; i <= 10; i++) {
			int sign = 1;
			long product = 1;
			long sum = 1;

			for (int exponent = 1; exponent <= 10; exponent++) {
				product *= i;
				sign = -sign;
				sum += product * sign;
			}

			trueCoefficients[i - 1] = sum;
		}

		System.out.println(Arrays.toString(trueCoefficients));

		long result = 0;

		for (int i = 1; i <= trueCoefficients.length; i++) {
			long[][] equations = new long[i][i + 1];

			for (int j = 0, product = 1; j < i; j++, product++) {
				long tempProduct = 1;

				for (int k = i - 1; k >= 0; k--, tempProduct *= product) {
					equations[j][k] = tempProduct;
				}
			}

			for (int j = 0; j < i; j++) {
				equations[j][i] = trueCoefficients[j];
			}

			long[] coefficients = new long[i];
			solveEquationSystem(equations, coefficients);
			System.out.print(Arrays.toString(coefficients));

			long next = 0, product = 1;

			for (int j = coefficients.length - 1; j >= 0; j--, product *= (i + 1)) {
				next += coefficients[j] * product;
			}

			System.out.println(next);
			result += next;
		}

		System.out.println(result);
	}
}
