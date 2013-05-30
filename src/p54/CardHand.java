/**
 * 
 */
package p54;

/**
 * @author LG
 * 
 */
public class CardHand {
	private Card[] cards;

	/**
	 * @return the cards
	 */
	public Card[] getCards() {
		return cards;
	}

	private CardHand() {
	}

	public static CardHand[] parse(String display) {
		CardHand[] hands = new CardHand[2];
		String[] cardStrings = display.split("\\s+");

		// Create the hands
		hands[0] = new CardHand();
		hands[0].cards = new Card[5];

		hands[1] = new CardHand();
		hands[1].cards = new Card[5];

		for (int i = 0; i < 5; i++) {
			hands[0].cards[i] = new Card(cardStrings[i]);
			hands[1].cards[i] = new Card(cardStrings[i + 5]);
		}

		return hands;
	}

	public void sortHandByVal() {
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getValue() > cards[j].getValue()) {
					Card temp = cards[i];
					cards[i] = cards[j];
					cards[j] = temp;
				}
			}
		}
	}

	public void sortHandByType() {
		for (int i = 0; i < cards.length - 1; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getType() > cards[j].getType()) {
					Card temp = cards[i];
					cards[i] = cards[j];
					cards[j] = temp;
				}
			}
		}
	}

	public boolean greaterThan(CardHand hand) {
		CardHandRanking selfRanking = CardHandRanking.rankOf(this);
		CardHandRanking otherRanking = CardHandRanking.rankOf(hand);

		int compareTo = selfRanking.compareTo(otherRanking);

		if (compareTo == 0) {
			System.out.println(this + " >< " + hand);
		}

		return (compareTo > 0);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < cards.length; i++) {
			stringBuilder.append(cards[i].toString());
			stringBuilder.append(" ");
		}

		return stringBuilder.toString();
	}
}