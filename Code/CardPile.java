/**
 * CSCI 1913 Project 2 - UnoWarMatch
 * Name: Jun Hao Cheh
 *
 * This class represents a pile of playing cards.
 */

public class CardPile {
    private Card topCard;
    private int numCardsOnPile = 1;

    /**
     * This constructor creates a new card pile.
     * @param topCard a card from the deck
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
    }

    /**
     * This method checks if the input card (from hand) is legal to play on the current topCard of the cardPile.
     * @param card Card from hand
     * @return boolean value indicating whether input card (from hand) is legal
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            return false;
        }
        if (card.getSuitName().equals(topCard.getSuitName())){
            return true;
        }
        else return card.getRankNum() >= topCard.getRankNum();
    }

    /**
     * Add another card to the card pile, making it the new top card.
     * @param card card in hand
     */
    public void play(Card card) {
        // Check for invalid moves
        if (!canPlay(card)) {
            System.out.println("Illegal move detected");
        } else {
            numCardsOnPile+=1;
            topCard = card; // newly placed card would be new topCard
        }
    }

    public int getNumCards() {
        return numCardsOnPile;
    }

    public Card getTopCard() {
        return topCard;
    }

}
