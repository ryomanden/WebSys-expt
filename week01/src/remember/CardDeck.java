package remember;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    List<Integer> cards;

    public CardDeck() {
        cards = new ArrayList<>();
//        cards.add(1);
//        cards.add(15);
//        cards.add(31);
//        cards.add(49);
//        cards.add(52);

        // create Deck
        for(int i = 1; i <= 52; i++) {
            cards.add(i);
        }
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
        return cards.get(x);
    }

    private static String code2label(int code) {
        String ans = "";
        char char1[] = {'S', 'H', 'D', 'C'};
        char char2[] = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};

        ans = String.valueOf(char1[(code - 1) / 13]);
        ans += String.valueOf(char2[(code - 1) % 13]);

        return ans;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int takeCard() {
        cards.remove(0);
        return 0;
    }

    public static void main(String args[]) {
        CardDeck deck = new CardDeck();
        System.out.println(deck.getCodeAt(3));
        System.out.println(deck.getSize());
        int c1 = deck.getCodeAt(0);
        System.out.println(code2label(c1));
        int c2 = deck.getCodeAt(1);
        System.out.println(code2label(c2));
        deck.print();
        deck.shuffle();
        deck.print();
        deck.takeCard();
        deck.print();
//        deck.takeCard();
//        deck.print();
//        deck.takeCard();
//        deck.print();
    }
}
