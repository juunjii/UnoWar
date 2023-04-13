/**
 * CSCI 1913 Project 2 - UnoWarMatch
 * Name: Jun Hao Cheh
 *
 * This class represents an AI that plays the lowest-rank valid card in its hard.
 */
public class SmallestCardAI extends AI {

    /**
     * This method finds the smallest valid card from the AI's hand and returns it to mark it as the card
     * the AI intends to play
     * @param hand the hand of cards
     * @param cardPile cards on the card pile
     * @return returns the smallest valid card that the AI intends to play, if there is no valid card, return will be
     * null
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        // Initialize smallestRankedCard to null, if there is no valid card, return will be null
        Card smallestRankedCard = null;
        for (int i = 0; i< hand.getSize(); i++) {
            if (cardPile.canPlay(hand.get(i)) )  {
                // Set smallestRankedCard to be the first valid card
                if (smallestRankedCard == null) {
                    smallestRankedCard = hand.get(i);
                }
                // Compare the rankNum of current smallestRankedCard to the next valid card's rankNum to
                // find the smaller one among them
                if (smallestRankedCard.getRankNum() > hand.get(i).getRankNum()) {
                    smallestRankedCard = hand.get(i); // smallestRankedCard will be the new smallest card in hand
                }
            }

        }

        return smallestRankedCard;
    }
    @Override
    public String toString() {
        return "Smallest Card AI";
    }

}
