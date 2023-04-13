/**
 * CSCI 1913 Project 2 - UnoWarMatch
 * Name: Jun Hao Cheh
 *
 * This class serves as both as a Random AI, and the parent class for other AIs.
 */
public class AI {
    private Hand hand;
    private CardPile cardPile;

    /**
     * This method finds a random (first) valid card from the AI's hand and returns it to mark it as the card
     * the AI intends to play
     * @param hand the hand of cards
     * @param cardPile cards on the card pile
     * @return returns the random valid card that the AI intends to play; null when there is no card that can be played
     * on the card pile
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (int i = 0; i< hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i)))  {
                return hand.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Random Card AI";
    }


}
