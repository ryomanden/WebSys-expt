package remember;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    List<Integer> cards;

    public CardDeck() {
        cards = new ArrayList<>();
        cards.add(1);
        cards.add(15);
        cards.add(31);
        cards.add(49);
        cards.add(52);
    }

    public void print() {
        for(int i =0; i < cards.size(); i++) {
            int c = cards.get(i);
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return cards.size();
    }

    public int getCodeAt(int x) {
        return 0;
    }

    private static String code2label(int code) {
        return "" + code;
    }

    public void shuffle() {

    }

    public int takeCard() {
        return 0;
    }

    public static void main(String args[]) {
        CardDeck deck = new CardDeck();
        System.out.println(deck.getCodeAt(3));
        System.out.println(deck.getSize());
        int c1 = deck.getCodeAt(0);
        System.out.println(code2label(c1));
        int c2 = deck.getCodeAt(2);
        System.out.println(code2label(c2));
        deck.print();
    }
}
