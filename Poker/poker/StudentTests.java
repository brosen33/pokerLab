package poker;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTests {

	/* these first set of tests are for the Deck.java */
	// @Test
	public void myDeckTest() {
		Deck deck = new Deck();
		String str = "";
		for (int i = 0; i < 52; i++) {
			str += deck.getCardAt(i);
			str += "\n";
		}
		System.out.println(str);
	}

	 @Test
	public void shuffleTest() {
		Deck deck = new Deck();
		deck.shuffle();
		String str = "";
		for (int i = 0; i < 52; i++) {
			str += deck.getCardAt(i);
			str += "\n";
		}
		System.out.println(str);
	}

	// @Test
	public void cutTest() {
		Deck deck = new Deck();
		deck.cut(7);
		String str = "";
		for (int i = 0; i < 52; i++) {
			str += deck.getCardAt(i);
			str += "\n";
		}
		System.out.println(str);
	}

	// @Test
	public void dealTest() { // is this printing what I want??
		Deck deck = new Deck();
		deck.deal(5);
		String str = "";
		for (int i = 0; i < 5; i++) {
			str += deck.getCardAt(i);
			str += "\n";
		}
		System.out.println(str);
	}

	   @Test
	public void getterTest() {
		Deck deck = new Deck();
		String str = "";
		
		assertTrue(deck.getNumCards()==52);
		System.out.println(deck.getCardAt(0));
		
	}

	/* the following tests are for the PokerHandEvaluator.java */
	 @Test
	public void hasPairTest() { // good
		Card[] hand = { new Card(1, 0), new Card(1, 2), new Card(3, 1), new Card(4, 3), new Card(5, 0) };

		assertTrue(PokerHandEvaluator.hasPair(hand) == true);
		assertTrue(PokerHandEvaluator.hasTwoPair(hand) == false);
		assertTrue(PokerHandEvaluator.hasFullHouse(hand) == false);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFlush(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraight(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand)== false);
	}

	 @Test
	public void hasTwoPairTest() { // good
		Card[] hand = { new Card(1, 0), new Card(1, 2), new Card(3, 1), new Card(3, 3), new Card(5, 0) };
		
		assertTrue(PokerHandEvaluator.hasPair(hand) == true);
		assertTrue(PokerHandEvaluator.hasTwoPair(hand) == true);
		assertTrue(PokerHandEvaluator.hasFullHouse(hand) == false);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFlush(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraight(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand)== false);
	}

	 @Test
	public void hasFullHouseTest() { // good
		Card[] hand = { new Card(1, 0), new Card(1, 2), new Card(3, 1), new Card(3, 3), new Card(3, 0) };
		
		assertTrue(PokerHandEvaluator.hasPair(hand) == true);
		assertTrue(PokerHandEvaluator.hasTwoPair(hand) == true);
		assertTrue(PokerHandEvaluator.hasFullHouse(hand) == true);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(hand)== true);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFlush(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraight(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand)== false);
	}

	 @Test
	public void hasThreeKindTest() { // good
		Card[] hand = { new Card(12, 0), new Card(10, 2), new Card(3, 1), new Card(3, 3), new Card(3, 0) };

		assertTrue(PokerHandEvaluator.hasPair(hand) == true);
		assertTrue(PokerHandEvaluator.hasTwoPair(hand) == false);
		assertTrue(PokerHandEvaluator.hasFullHouse(hand) == false);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(hand)== true);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFlush(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraight(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand)== false);
	}

	 @Test
	public void hasFlushTest() { // good
		Card[] hand = { new Card(1, 0), new Card(2, 0), new Card(3, 0), new Card(6, 0), new Card(12, 0) };

		assertTrue(PokerHandEvaluator.hasPair(hand) == false);
		assertTrue(PokerHandEvaluator.hasTwoPair(hand) == false);
		assertTrue(PokerHandEvaluator.hasFullHouse(hand) == false);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFlush(hand)== true);
		assertTrue(PokerHandEvaluator.hasStraight(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand)== false);

	}

	 @Test
	public void hasFourKindTest() { // good
		Card[] hand = { new Card(1, 0), new Card(1, 2), new Card(1, 1), new Card(1, 3), new Card(5, 0) };

		assertTrue(PokerHandEvaluator.hasPair(hand) == true);
		assertTrue(PokerHandEvaluator.hasTwoPair(hand) == false);
		assertTrue(PokerHandEvaluator.hasFullHouse(hand) == false);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(hand)== true);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(hand)== true);
		assertTrue(PokerHandEvaluator.hasFlush(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraight(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand)== false);
	}

	 @Test
	public void hasStraightTest() {
		Card[] hand = { new Card(1, 0), new Card(2, 2), new Card(4, 1), new Card(3, 3), new Card(5, 0) };

		assertTrue(PokerHandEvaluator.hasPair(hand) == false);
		assertTrue(PokerHandEvaluator.hasTwoPair(hand) == false);
		assertTrue(PokerHandEvaluator.hasFullHouse(hand) == false);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFlush(hand)== false);
		assertTrue(PokerHandEvaluator.hasStraight(hand)== true);
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand)== false);
	}

	 @Test
	public void hasStraightFlushTest() {
		Card[] hand = { new Card(1, 0), new Card(2, 0), new Card(4, 0), new Card(3, 0), new Card(5, 0) };

		assertTrue(PokerHandEvaluator.hasPair(hand) == false);
		assertTrue(PokerHandEvaluator.hasTwoPair(hand) == false);
		assertTrue(PokerHandEvaluator.hasFullHouse(hand) == false);
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFourOfAKind(hand)== false);
		assertTrue(PokerHandEvaluator.hasFlush(hand)== true);
		assertTrue(PokerHandEvaluator.hasStraight(hand)== true);
		assertTrue(PokerHandEvaluator.hasStraightFlush(hand)== true);
	}
	 
	  @Test
	 public void StraightAceTest() {
		 Card[] hand = { new Card(1, 0), new Card(10, 0), new Card(12, 0), new Card(11, 0), new Card(13, 0) };
		 
		 assertTrue(PokerHandEvaluator.hasStraight(hand) == true);
	 }
}