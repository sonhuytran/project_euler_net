/**
 * 
 */
package p102;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P102_Triangle {

	private P102_Pointf a;
	private P102_Pointf b;
	private P102_Pointf c;

	/**
	 * @return the a
	 */
	public P102_Pointf getA() {
		return a;
	}

	/**
	 * @param a
	 *            the a to set
	 */
	public void setA(P102_Pointf a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public P102_Pointf getB() {
		return b;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(P102_Pointf b) {
		this.b = b;
	}

	/**
	 * @return the c
	 */
	public P102_Pointf getC() {
		return c;
	}

	/**
	 * @param c
	 *            the c to set
	 */
	public void setC(P102_Pointf c) {
		this.c = c;
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 */
	public P102_Triangle(P102_Pointf a, P102_Pointf b, P102_Pointf c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	private static float sign(P102_Pointf p1, P102_Pointf p2, P102_Pointf p3) {
		return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY())
				- (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
	}

	private static boolean pointInTriangle(P102_Pointf pt, P102_Pointf v1,
			P102_Pointf v2, P102_Pointf v3) {
		boolean b1, b2, b3;

		b1 = sign(pt, v1, v2) < 0.0f;
		b2 = sign(pt, v2, v3) < 0.0f;
		b3 = sign(pt, v3, v1) < 0.0f;

		return ((b1 == b2) && (b2 == b3));
	}

	public boolean containsPoint(P102_Pointf pt) {
		return pointInTriangle(pt, a, b, c);
	}
}
