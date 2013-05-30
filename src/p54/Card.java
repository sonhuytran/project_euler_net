/**
 * 
 */
package p54;

/**
 * @author LG
 * 
 */
public class Card {

	private int value;
	private char type;

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the type
	 */
	public char getType() {
		return type;
	}

	public Card(String display) {
		switch (display.charAt(0)) {
		case 'T':
			this.value = 10;
			break;

		case 'J':
			this.value = 11;
			break;

		case 'Q':
			this.value = 12;
			break;

		case 'K':
			this.value = 13;
			break;

		case 'A':
			this.value = 14;
			break;

		default:
			this.value = Integer.valueOf(display.substring(0, 1));
			break;
		}

		this.type = display.charAt(1);
	}

	@Override
	public String toString() {
		return String.format("%d%c", this.value, this.type);
	}
}