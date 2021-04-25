package poker;

public class Deck {

	private Card[] cards;

	public Deck() { // fine
		Card[] deck = new Card[52];
		int count = 0;

		for (int s = 0; s < 4; s++) {
			for (int v = 1; v <= 13; v++) {
				deck[count] = new Card(v, s);
				count++;
			}
		}
		cards = deck;
		System.out.println(deck);
	}

	public Deck(Deck other) { // fine, maybe ask about this being a reference copy
		Card[] copy = new Card[other.cards.length];

		for (int i = 0; i < other.cards.length; i++) {
			copy[i] = other.cards[i];
		}
		cards = copy;
	}

	public Card getCardAt(int position) { // fine
		return cards[position];
	}

	public int getNumCards() { // fine
		return cards.length;
	}

	public void shuffle() { 
		Card[] deck = new Card[cards.length];
		if (cards.length % 2 == 0) {
			for (int i = 0; i < cards.length; i += 2) {
				deck[i] = cards[i / 2];
				deck[i + 1] = cards[cards.length / 2 + i / 2];
			}
		} else { 
			int top = 0;
			int bottom = cards.length/ 2 + 1;
			for (int i = 0; i < cards.length; i++) {
															
				if (i % 2 == 0) {
					deck[i] = cards[top];
					top ++;
				}
				else {
					deck[i] = cards[bottom];
					bottom ++;
				}
			}
		}
		cards = deck;
	}

	public void cut(int position) {
		Card[] deck = new Card[position];
		for (int i = 0; i < position; i++) {
			deck[i] = cards[i];
		}
		for (int j = position; j < cards.length; j++) {
			cards[j - position] = cards[j];
		}
		for (int k = cards.length - position; k < cards.length; k++) {
			cards[k] = deck[k - cards.length + position];
		}

	}

	public Card[] deal(int numCards) { // working on the driver. not sure if printing right on S.T.

		Card[] smaller = new Card[cards.length - numCards];
		for (int i = 0; i < cards.length - numCards; i++) {
			smaller[i] = cards[i + numCards];
		}

		Card[] dealt = new Card[numCards];

		for (int i = 0; i < numCards; i++) {
			dealt[i] = cards[i];
		}

		cards = smaller;

		return dealt;
	}

}
