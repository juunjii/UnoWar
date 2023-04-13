/**
 * CSCI 1913 Project 2 - UnoWarMatch
 * Name: Jun Hao Cheh
 *
 * This class represents a match-up of two AIs at UnoWar (one match-up may be settled by
 * thousands of actual games, this object handles both single games, and multiple game series).
 */
public class UnoWarMatch {

    private AI ai1;
    private AI ai2;

    /**
     * This constructor create new games between chosen ai1 and ai2
     * @param ai1 AI (random-card AI)/ SmallestCardAI / BiggestCaraAI
     * @param ai2 AI (random-card AI)/ SmallestCardAI / BiggestCaraAI
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;

    }


    /**
     * This method plays a single round of Uno War.
     * @param turn true if it's ai1's turn, false if it's ai2's turn
     * @param deck the deck of cards
     * @param hand1 ai1's hand
     * @param hand2 ai2's hand
     * @return true if ai1 wins rounds, false if ai2 wins round
     */
    private boolean playRound(boolean turn, Deck deck, Hand hand1, Hand hand2) {
        boolean roundWinner = true;
        CardPile cardPile = new CardPile(deck.draw()); // New card piles are created every round

        // Round will continue until one AI wins the round (break)
        while (true) {
            // if turn is true, it's ai1's turn
            if (turn) {
                if (ai1.getPlay(hand1, cardPile) != null) {
                    // find valid card in ai1's hand
                    Card validCard1 = ai1.getPlay(hand1, cardPile);
                    // valid Cards would be placed on the deck
                    cardPile.play(validCard1);
                    // valid Cards will be removed from hand
                    hand1.remove(validCard1);
                    turn = false; // ai2's turn
                }
                // if ai1 can't place a card, ai2 will be the winner (false)
                else if (ai1.getPlay(hand1, cardPile) == null) {
                    roundWinner = false;
                    break;
                }
            }

            // if turn is false, it is ai2's turn
            if (!turn) {
                if (ai2.getPlay(hand2, cardPile) != null) {
                    // find valid card in ai2's hand
                    Card validCard2 = ai1.getPlay(hand2, cardPile);
                    // Valid Cards would be placed on the deck
                    cardPile.play(validCard2);
                    // Valid Cards will be removed from hand
                    hand2.remove(validCard2);
                    turn = true; // ai1's turn
                }

                // if ai2 can't place a card, ai1 will be the winner (true)
                else if (ai2.getPlay(hand2, cardPile) == null) {
                    roundWinner = true;
                    break;
                }
            }

        }
            return roundWinner;

        }


    /**
     * This method plays a single game of Uno War.
     *
     * @return true if ai1 wins; false if ai2 wins
     */
    public boolean playGame() {
        Deck deck = new Deck();
        Hand hand1 = new Hand(deck, 5); // ai1's hand
        Hand hand2 = new Hand(deck, 5); // ai2's hand
        int ai1Score = 0;
        int ai2Score = 0;
        boolean winner = false; // winner initialized to be ai2
        boolean temp; // temp variable to store playRound method
        boolean turn = true; // first turn belongs to ai1
        while (ai1Score <= 10 && ai2Score <= 10) {

            temp = playRound(turn, deck, hand1, hand2);
            // if ai2 can't place a card, ai1 will be the winner (true), ai1Score will increase
            if (temp) {
                ai1Score += 1;

                turn = true; // if ai2 loses the round, next round's turn (true) will belong to ai1
            }
            // if ai1 can't place a card, ai2 will be the winner (false), ai2Score will increase
            if (!temp) {
                ai2Score += 1;

                turn = false; // if ai1 loses the round, next round's turn (false) will belong to ai2
            }

            // ai1 wins (reaches score 10)
            if (ai1Score == 10) {
                winner = true;
                break;
            }

        }

        return winner;
    }

    /**
     * This method should have the AIs play each other nTrials times, and report the percent of
     * times (0-1 inclusive) ai1 beats ai2 as a double. (eg: '1' = 100% of time ai1 wins, '0' = ai1 always loses)
     *
     * @param nTrials number of times that ai1 and ai2 play each other
     * @return percent of times ai1 beats ai2 as a double
     */
    public double winRate(int nTrials) {

        double winRate = 0.0;
        double count1 = 0;
        boolean temp = false;

        // Calculates the number of times ai1 wins in nTrials amount of games
        for (int i = 0; i <= nTrials; i++) {
            temp = playGame(); // play the game nTrials amount of times
            // ai1 wins
            if (temp) {
                count1 += 1.0;
            }

        }
        // calculate winrate of ai1 in nTrials amount of games
        winRate = (count1 / nTrials);
        return winRate;
    }

}