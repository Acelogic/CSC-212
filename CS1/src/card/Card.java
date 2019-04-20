package card;

public class Card implements CardSpecification {
    // The Anatomy of a Class file


    // 1) Instance Variables / Fields

    private String rank;
    private String suit;

    // 2) Constructors
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // 3) Methods
    public String toString() {
        String representation = "(" + rank + "," + suit + ")";
        return representation;
    }


    @Override
    public String rank() {
        return rank;
    }

    @Override
    public String suit() {
        return suit;
    }

    @Override
    public String color() {
        if (suit.equalsIgnoreCase("Spade") | suit.equalsIgnoreCase("Club")) {
            return "black";
        } else {
            return "red";
        }
    }

    @Override
    public boolean royal() {
        return (rank.equalsIgnoreCase("Jack") | rank.equalsIgnoreCase("Queen")
                | rank.equalsIgnoreCase("King"));
    }

    @Override
    public boolean oneEyedJack() {
        return rank.equalsIgnoreCase("Jack") & suit.equalsIgnoreCase("heart")
                | suit.equalsIgnoreCase("Spade");
    }

    @Override
    public int hcp() {
        if (rank.equalsIgnoreCase("Ace")) {
            return 4;
        }
        if (rank.equalsIgnoreCase("King")) {
            return 3;
        }
        if (rank.equalsIgnoreCase("Queen")) {
            return 2;
        }
        if (rank.equalsIgnoreCase("Jack")) {
            return 1;
        }
        return 0;

    }

    private int[] weights = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};

    @Override
    public int weight() {
        for (int i = 0; i < rank.length(); i = i + 1) {
            if (rank.equalsIgnoreCase(ranks[i])) {
                return weights[i];
            }
        }
        return 0;
    }

    @Override
    public boolean eqRank(Card c) {
        return rank.equalsIgnoreCase((c.rank));
    }

    @Override
    public boolean eqSuit(Card c) {
        return suit.equalsIgnoreCase((c.suit));
    }

    @Override
    public boolean lessRank(Card c) {
        return weight() < c.weight();
    }

    @Override
    public boolean lessSuit(Card c) {
        return suitRank() < c.suitRank();
    }

    private int suitRank(){
        if(suit.equalsIgnoreCase("club")){return 1;}
        if(suit.equalsIgnoreCase("diamond")){return 2;}
        if(suit.equalsIgnoreCase("heart")){return 3;}
        return 4;
    }
    @Override
    public String txtrep() {
        return "(" + txtrepRank() + "," +txtrepSuit() +")";
    }

    private String txtrepRank(){
        if(rank.equalsIgnoreCase("10")){
            return "X";
        }
        else{
            return  rank.substring(0,1).toUpperCase();
        }
    }

    private String txtrepSuit(){
        return suit.substring(0,1).toUpperCase();
    }















}
