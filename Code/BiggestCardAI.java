/**
 * CSCI 1913 Project 2 - UnoWarMatch
 * Name: Jun Hao Cheh
 *
 * This class represents an AI that plays the highest-rank valid card in its hand.
 */

public class BiggestCardAI extends AI {
    /**
     * This method finds the largest valid card from the AI's hand and returns it to mark it as the card
     * the AI intends to play
     * @param hand the hand of cards
     * @param cardPile cards on the card pile
     * @return returns the largest valid card that the AI intends to play, if there is no valid card, return will be
     * null
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        // Initialize largestRankedCard to null, if there is no valid card, return will be null
        Card largestRankedCard = null;
        for (int i = 0; i < hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i))) {
                // Set largestRankedCard to be the first valid card
                if (largestRankedCard == null) {
                    largestRankedCard = hand.get(i);
                }
                // Compare the rankNum of current largestRankedCard to the next valid card's rankNum to
                // find the larger one among them
                if (largestRankedCard.getRankNum() < hand.get(i).getRankNum()) {
                    largestRankedCard = hand.get(i); // largestRankedCard will be the new largest card in hand
                }
            }

        }
        return largestRankedCard;
    }
        @Override
        public String toString () {
            return "Biggest Card AI";
        }


}
