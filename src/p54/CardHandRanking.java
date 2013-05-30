/**
 * 
 */
package p54;

/**
 * @author LG
 * 
 */
public class CardHandRanking {
	private int ranking;
	private int rankingValue;

	private static final int HIGH_CARD = 0;
	private static final int ONE_PAIR = 1;
	private static final int TWO_PAIRS = 2;
	private static final int THREE_OF_A_KIND = 3;
	private static final int STRAIGHT = 4;
	private static final int FLUSH = 5;
	private static final int FULL_HOUSE = 6;
	private static final int FOUR_OF_A_KIND = 7;
	private static final int STRAIGHT_FLUSH = 8;
	private static final int ROYAL_FLUSH = 9;

	/**
	 * @return the ranking
	 */
	public int getRanking() {
		return ranking;
	}

	/**
	 * @param ranking
	 *            the ranking to set
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	/**
	 * @return the rankingValue
	 */
	public int getRankingValue() {
		return rankingValue;
	}

	/**
	 * @param rankingValue
	 *            the rankingValue to set
	 */
	public void setRankingValue(int rankingValue) {
		this.rankingValue = rankingValue;
	}

	private CardHandRanking() {
	}

	private CardHandRanking(int ranking, int rankingValue) {
		this.ranking = ranking;
		this.rankingValue = rankingValue;
	}

	public static CardHandRanking rankOf(CardHand hand) {
		hand.sortHandByVal();

		// Check straight
		boolean straight = true;
		Card[] cards = hand.getCards();

		for (int i = 1; i < cards.length; i++) {
			if (cards[i].getValue() - cards[i - 1].getValue() != 1) {
				straight = false;
			}
		}

		// Check flush
		boolean flush = true;

		for (int i = 1; i < cards.length; i++) {
			if (cards[i].getType() != cards[0].getType()) {
				flush = false;
			}
		}

		if (straight && flush) {
			if (cards[0].getValue() == 10) {
				return new CardHandRanking(ROYAL_FLUSH, 10);
			} else {
				return new CardHandRanking(STRAIGHT_FLUSH, cards[0].getValue());
			}
		}

		// Check four of a kind
		if (cards[0].getValue() == cards[3].getValue()
				|| cards[1].getValue() == cards[4].getValue()) {
			return new CardHandRanking(FOUR_OF_A_KIND, cards[2].getValue());
		}

		// Check full house
		if (cards[0].getValue() == cards[2].getValue()
				&& cards[3].getValue() == cards[4].getValue()) {
			return new CardHandRanking(FULL_HOUSE, cards[0].getValue());
		} else if (cards[0].getValue() == cards[1].getValue()
				&& cards[2].getValue() == cards[4].getValue()) {
			return new CardHandRanking(FULL_HOUSE, cards[2].getValue());
		}

		if (flush) {
			return new CardHandRanking(FLUSH, cards[4].getValue());
		}

		if (straight) {
			return new CardHandRanking(STRAIGHT, cards[4].getValue());
		}

		// Check three of a kind
		if (cards[0].getValue() == cards[2].getValue()
				|| cards[1].getValue() == cards[3].getValue()
				|| cards[2].getValue() == cards[4].getValue()) {
			return new CardHandRanking(THREE_OF_A_KIND, cards[2].getValue());
		}

		// Check two pairs
		if ((cards[0].getValue() == cards[1].getValue() && cards[2].getValue() == cards[3]
				.getValue())
				|| (cards[0].getValue() == cards[1].getValue() && cards[3]
						.getValue() == cards[4].getValue())
				|| (cards[1].getValue() == cards[2].getValue() && cards[3]
						.getValue() == cards[4].getValue())) {
			return new CardHandRanking(TWO_PAIRS, cards[3].getValue());
		}

		// Check one pair
		for (int i = 1; i < cards.length; i++) {
			if (cards[i].getValue() == cards[i - 1].getValue()) {
				return new CardHandRanking(ONE_PAIR, cards[i].getValue());
			}
		}

		return new CardHandRanking(HIGH_CARD, cards[4].getValue());
	}

	public int compareTo(CardHandRanking cardHandRanking) {
		if (this.ranking > cardHandRanking.ranking) {
			return 1;
		}

		if (this.ranking < cardHandRanking.ranking) {
			return -1;
		}

		if (this.rankingValue > cardHandRanking.rankingValue) {
			return 1;
		}

		if (this.rankingValue < cardHandRanking.rankingValue) {
			return -1;
		}

		return 0;
	}
}
