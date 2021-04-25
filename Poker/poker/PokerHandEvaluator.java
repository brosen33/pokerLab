package poker;

import static org.junit.Assert.assertTrue;

public class PokerHandEvaluator {

	private static int suitOccurances(Card[] array, int value) {
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i].getSuit() == value) {
				count++;
			}
		}
		return count;
	}

	private static int numberOfOccurances(Card[] array, int value) {
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i].getValue() == value) {
				count++;
			}
		}
		return count;
	}

	public static boolean hasPair(Card[] cards) {
		boolean hand = false;
		for (int i = 1; i <= 13; i++) {
			if (numberOfOccurances(cards, i) >= 2) {
				hand = true;
			}
		}
		return hand;
	}

	public static boolean hasTwoPair(Card[] cards) {
		boolean hand = false;
		boolean first = false;
		boolean second = false;
		for (int i = 1; i <= 13; i++) {
			if (numberOfOccurances(cards, i) >= 2) {
				first = true;
				for (int j = 1; j <= 13; j++) {
					if (numberOfOccurances(cards, j) >= 2 && i != j) {
						second = true;
					}
				}
			}
		}
		if (second == true && first == true) {
			hand = true;
		}
		return hand;
	}

	public static boolean hasThreeOfAKind(Card[] cards) {
		boolean hand = false;
		for (int i = 0; i <= 13; i++) {
			if (numberOfOccurances(cards, i) >= 3) {
				hand = true;
			}
		}
		return hand;
	}

	public static boolean hasStraight(Card[] cards) {
		boolean hand = false;
		int lowest = 14;
		int highest = 0;
		for (int i = 0; i < cards.length; i++) {
			int a = cards[i].getValue();
			int b = cards[i].getValue();
			if (a < lowest) {
				lowest = a;
			}
			if (b > highest) {
				highest = b;
			}
		}
		if (lowest == 1 && highest == 13) {
			int a = numberOfOccurances(cards, 10);
			int b = numberOfOccurances(cards, 11);
			int c = numberOfOccurances(cards, 12);
			
			if (a==1 && b==1 && c ==1) {
				hand = true;
			}
			return hand;
		}
		for (int j = 1; j < 5; j++) {
			if (numberOfOccurances(cards, lowest + j) != 1) {
				return false;
			}
			hand = true;
		}
		return hand;
	}

	public static boolean hasFlush(Card[] cards) {
		boolean hand = false;
		for (int i = 0; i <= 3; i++) {
			if (suitOccurances(cards, i) == 5) {
				hand = true;
			}
		}
		return hand;
	}

	public static boolean hasFullHouse(Card[] cards) {
		boolean hand = false;
		boolean first = false;
		for (int i = 1; i <= 13; i++) {
			if (numberOfOccurances(cards, i) == 2) {
				first = true;
			}
			for (int j = 1; j <= 13; j++) {
				if (numberOfOccurances(cards, j) == 3 && first == true) {
					hand = true;
				}
			}
		}
		return hand;
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		boolean hand = false;
		for (int i = 1; i <= 13; i++) {
			if (numberOfOccurances(cards, i) >= 4) {
				hand = true;
			}
		}
		return hand;
	}

	public static boolean hasStraightFlush(Card[] cards) {
		boolean hand = false;
		if (hasStraight(cards) == true && hasFlush(cards) == true) {
			hand = true;
		}
		return hand;
	}
}
