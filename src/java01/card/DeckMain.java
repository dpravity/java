package java01.card;

public class DeckMain {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Card card = deck.pick();
        System.out.println(card);

        deck.shuffle();

        card = deck.pick(0);
        System.out.println(card);
    }
}
