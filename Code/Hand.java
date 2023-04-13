

/**
 * CSCI 1913 Project 2 - UnoWarMatch
 * Name: Jun Hao Cheh
 *
 * This class represents a hand of playing cards.
 */
public class Hand {
    private int size;
    private Deck deck;
    private Card[] handOfCards;

    /**
     * Constructor for class hand, creates hand from the deck
     * @param deck deck of cards
     * @param size hand size
     */

    public Hand(Deck deck, int size) {
        this.deck = deck;
        this.size = size;
        handOfCards = new Card[size];
        for (int h = 0; h < size; h++) {
            handOfCards[h] = deck.draw();
        }
    }

    public int getSize() {
        return size;
    }

    /**
     * This method gets the card at the given index in player's hand. If index is out of bounds, an error message
     * would be printed, and return the first card in hand.
     * @param i given index to get Card ('0' would get first card, '1' would get second card, etc..)
     * @return the card at the given index, if index is out of bounds, an error message will be printed and the
     * first card of the hand will be returned.
     */
    public Card get(int i) {
        if (i >= size || i < 0) {
            System.out.println("Invalid hand index!");
            i = 0;
        }
        return handOfCards[i];
    }

    /**
     * This method remove a given card from the hand. If a card is found in the hand, it should be removed, and a
     * replacement card should be drawn from the deck. If the card is not found in the hand, this method would
     * return false.
     *
     * @param card Card in hand
     * @return boolean value to indicate whether the card is found in the hand, and can be removed.
     */
    public boolean remove(Card card) {
        // null check for card in hand
        if (card == null) {
            return false;
        }
        // if card is found in hand, it is 'removed' and replaced with a card from the deck
        for (int i = 0; i < handOfCards.length; i++) {
            if (card.equals(handOfCards[i])) {
                handOfCards[i] = deck.draw();
                return true;
            }
        }
        return false; // if card is not found in hand
    }
}

