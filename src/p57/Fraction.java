package p57;

import java.math.BigInteger;

public class Fraction {
	public BigInteger numerator;
	public BigInteger denominator;

	public Fraction(BigInteger numerator, BigInteger denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Fraction add1() {
		return new Fraction(numerator.add(denominator), denominator);
	}

	@Override
	public String toString() {
		return String.format("%s/%s", numerator.toString(),
				denominator.toString());
	}
}
