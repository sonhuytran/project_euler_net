/**
 * 
 */
package p243;

/**
 * @author Son-Huy TRAN
 * 
 */
public class Fraction {
	private int numerator;
	private int denominator;

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public Fraction(int numerator, int denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

	public boolean lessThan(Fraction value) {
		return (this.numerator * 1.0 / this.denominator) < (value.numerator * 1.0 / value.denominator);

		// long gcd = P243_Resilience.greatestCommonDivisor(this.denominator,
		// value.denominator);
		// long f1 = value.denominator / gcd, f2 = this.denominator / gcd;
		//
		// return (this.numerator * f1) < (value.numerator * f2);
	}
}
