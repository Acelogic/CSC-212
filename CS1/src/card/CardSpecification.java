package card;

public interface CardSpecification {
    public String rank();

    public String suit();

    public String color();

    public boolean royal();

    public boolean oneEyedJack();

    public int hcp();

    public int weight();

    public boolean eqRank(Card c);

    public boolean eqSuit(Card c);

    public boolean lessRank(Card c);

    public boolean lessSuit(Card c);

    public String txtrep();


}
