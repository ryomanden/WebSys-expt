package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerModel {
	int games;
	public PokerModel() {

		deckcards = new ArrayList<>();
		handcards = new ArrayList<>();
	}

	public void reset() {
		games = 0;
		chips = 500;
	}
	
	public void nextgame() {
		
		deckcards.clear();
		for (int i=1; i<=52; i++) {
			deckcards.add(i);
		}
		Collections.shuffle(deckcards);
		
		handcards.clear();
		for (int i=0; i<5; i++) {
			int n = deckcards.remove(0);
			handcards.add(n);
		}
		
		System.out.printf("%d: ", deckcards.size());
		for (int n: deckcards) {
			System.out.printf("%d ", n);
		}
		System.out.println();
		message = "交換するカードをチェックしてください";
		buttonLabel = "交換";
		games++;
	}

	public void change(List<String> index) {
		System.out.println("index="+index);

		for (String i: index) { // <-- Checked card's shuffle
			int c = deckcards.remove(0);
			handcards.set(Integer.parseInt(i), c);
		}
		
		evaluate();
		buttonLabel = "次のゲーム";
	}

	public void evaluate() {
		chips -= 100;
		message = "ノーペアです -100";
		if (chips == 0) {
			message += " ゲームオーバー";
		}
	}


	public int getGames() {
		return games;
	}


	int chips;

	List<Integer> deckcards;

	List<Integer> handcards;

	String buttonLabel;

	String message;


	public int getChips() {
		return chips;
	}

	public int getHandcardAt(int i) {
		return handcards.get(i);
	}

	public String getButtonLabel() {
		return buttonLabel;
	}

	public String getMessage() {
		return message;
	}
}