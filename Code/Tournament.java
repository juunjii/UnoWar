/**
 * CSCI 1913 Project 2 - UnoWarMatch
 * Name: Jun Hao Cheh
 *
 * This class is a driver class with a main method that reports the win-rate for every possible
 * pair of AIs.
 */
public class Tournament {
    public static void main(String[] args) {

        AI ai1 = new AI();
        AI ai2 = new BiggestCardAI();
        AI ai3 = new SmallestCardAI();

        UnoWarMatch gameRC1 = new UnoWarMatch(ai1,ai1);
        UnoWarMatch gameRC2 = new UnoWarMatch(ai1,ai2);
        UnoWarMatch gameRC3 = new UnoWarMatch(ai1,ai3);


        // Print the winrates from matches of random card AI vs. other AIs (including itself)
        System.out.println(ai1 + " vs. " +ai1+" winRate: "+ gameRC1.winRate(100000));
        System.out.println(ai1 + " vs. " +ai2+" winRate: "+ gameRC2.winRate(100000));
        System.out.println(ai1 + " vs. " +ai3+" winRate: "+ gameRC3.winRate(100000));

        // Print the winrates from matches of Smallest Card AI vs other AIs (including itself)
        UnoWarMatch gameSC1 = new UnoWarMatch(ai2,ai1);
        UnoWarMatch gameSC2 = new UnoWarMatch(ai2,ai2);
        UnoWarMatch gameSC3 = new UnoWarMatch(ai3,ai3);

        System.out.println(ai2 + " vs. " +ai1+" winRate: "+ gameSC1.winRate(100000));
        System.out.println(ai2 + " vs. " +ai2+" winRate: "+ gameSC2.winRate(100000));
        System.out.println(ai2 + " vs. " +ai3+" winRate: "+ gameSC3.winRate(100000));


        // Print the winrates from matches of Biggest Card AI vs other AIs (including itself)
        UnoWarMatch gameBC1 = new UnoWarMatch(ai3,ai1);
        UnoWarMatch gameBC2 = new UnoWarMatch(ai3,ai2);
        UnoWarMatch gameBC3 = new UnoWarMatch(ai3,ai3);

        System.out.println(ai3 + " vs. " +ai1+" winRate: "+ gameBC1.winRate(100000));
        System.out.println(ai3 + " vs. " +ai2+" winRate: "+ gameBC2.winRate(100000));
        System.out.println(ai3 + " vs. " +ai3+" winRate: "+ gameBC3.winRate(100000));


    }
}
