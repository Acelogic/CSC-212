package card;

public class CardTester {
    public static void main(String[] args) {
        Card c1 = new Card("King", "Spade");
        Card c2 = new Card("Jack", "Hearts");
        System.out.println(c1.rank());

        System.out.print(c1.suit());

        System.out.println(c1.color());

        System.out.println(c1.royal());

        System.out.println(c1.oneEyedJack());

        System.out.println(c1.hcp());

        System.out.println(c1.weight());

        System.out.println(c1.eqRank(c2));

        System.out.println(c1.eqSuit(c2));

        System.out.println(c1.lessRank(c2));

        System.out.println(c1.lessSuit(c2));

        System.out.println(c1.txtrep());
    }
}
