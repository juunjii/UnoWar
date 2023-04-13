import java.util.Random;

/**
 * CSCI 1913 Project 2 - UnoWarMatch
 * Name: Jun Hao Cheh
 *
 * This class represents a deck of playing cards.
 */

public class Deck {
    private final Card[] cardDeck =  new Card[52];
    private int dealtCardIndex = 0;


    /**
     * Creates a deck of cards.
     */
    public Deck() {
        int index = 0;
        for (int suit = 1; suit <= 4; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cardDeck[index] = new Card(rank, suit);
                index++;
            }
        }

        shuffle();
    }

    /**
     * This method shuffles the deck of cards with the Durstenfeld-Fisher-Yates algorithm.
     */
    public void shuffle() {
        int j = 0;
        for (int i = cardDeck.length -1;i> 0;i--) {
            Random r = new Random();
            // Generate random index to be exchanged with
            j = r.nextInt(i);
            Card temp = cardDeck[i];
            cardDeck[i] = cardDeck[j];
            cardDeck[j] = temp;

        }

    }

    /**
     * This method draws and return the next card in the deck.
     * @return the nextCard in the deck of cards.
     */
    public Card draw() {
       // If the deck is empty, shuffle the cards and then deal the new top of the deck
        if (isEmpty()) {
            shuffle();
            dealtCardIndex = 0;
        }
        Card nextCard = cardDeck[dealtCardIndex];
        ++dealtCardIndex;

        return nextCard;

    }

    /**
     * This method returns the number of cards remaining in the deck.
     * @return the number of cards remaining in the deck of cards
     */
    public int cardsRemaining() {
        return cardDeck.length-dealtCardIndex;
    }

    /**
     * This method indicates if the deck of cards is empty by boolean statements.
     * @return true if deck is empty, false if deck is not empty
     */
    public boolean isEmpty() {
        return cardsRemaining() == 0;
    }
}

