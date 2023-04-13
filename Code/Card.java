/**
 * CSCI 1913 Project 2 - UnoWarMatch
 * Name: Jun Hao Cheh
 *
 * This class represents one playing card.
 */
public class Card {
    private final int rankNum;
    private final int suit;
    private String rankName;
    private  String suitName;


    /**
     * This constructor validates the input rank and suit, if an invalid suit or rank is given it should print
     * an error message and initialize rankName to "Ace" and suitName to "Spades"
     *
     * @param rank the number of the card
     * @param suit the suit of the card - 1 represent Spades, 2 represents Hearts, 3 represents Clubs,
     *             4 represents Diamonds
     */
    public Card(int rank, int suit) {
        rankNum = rank;
        this.suit = suit;
        // Initialize rank names according to those represented by their respective numerical ranks
        switch (rank) {
            case 1 -> rankName = "Ace";
            case 2 -> rankName = "Two";
            case 3 -> rankName = "Three";
            case 4 -> rankName = "Four";
            case 5 -> rankName = "Five";
            case 6 -> rankName = "Six";
            case 7 -> rankName = "Seven";
            case 8 -> rankName = "Eight";
            case 9 -> rankName = "Nine";
            case 10 -> rankName = "Ten";
            case 11 -> rankName = "Jack";
            case 12 -> rankName = "Queen";
            case 13 -> rankName = "King";
        }

        // Initialize suit names according to those represented by their respective numerical suits
        switch (suit) {
            case 1 -> suitName = "Spades";
            case 2 -> suitName = "Hearts";
            case 3 -> suitName = "Clubs";
            case 4 -> suitName = "Diamonds";
        }

        // If rank and suit value is invalid
        if (rank < 1 || rank > 13 || suit < 1 || suit > 4) {
            System.out.println("Invalid card");
            rankName = "Ace";
            suitName = "Spades";

        }
    }

        public int getRankNum() {
            return rankNum;
        }

        public String getRankName () {
            return rankName;
        }

        public String getSuitName () {
            return suitName;
        }

        @Override
        public String toString () {
            return rankName + " " + "of" + " " + suitName;
        }

    /**
     * This method overwrites the default equal method. A Card should only be equal to
     * other instances of the Card class, and then only cards that have the same rank and suit.
     * @param obj object to be compared to instance of Card
     * @return true (equal) if other instances of the Card class is equal to Card, and if they have the same rank and
     * suit
     */
    @Override
        public boolean equals (Object obj){
            // Check for null case
            if (obj == null) {
                return false;
            }

            if (obj instanceof Card) {
                // Type cast obj into Card object, and assign it to variable "otherObj"
                Card otherObj = (Card) obj;
                // if different rankNum
                if (this.rankNum != otherObj.rankNum) {
                    return false;
                }

                // check suit
                return this.suit == otherObj.suit;
            }


            return true;
        }


    }


