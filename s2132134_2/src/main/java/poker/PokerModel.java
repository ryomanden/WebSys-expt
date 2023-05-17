package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerModel {
	int games;
	int count[], suit[];
	int two, three, four;
	boolean isStraight, isFlush;

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
		for (int i = 1; i <= 52; i++) {
			deckcards.add(i);
		}
		Collections.shuffle(deckcards);

		handcards.clear();
		for (int i = 0; i < 5; i++) {
			int n = deckcards.remove(0);
			handcards.add(n);
		}

		System.out.printf("%d: ", deckcards.size());
		for (int n : deckcards) {
			System.out.printf("%d ", n);
		}
		System.out.println();
		message = "交換するカードをチェックしてください";
		buttonLabel = "交換";
		games++;
	}

	public void change(List<String> index) {
		System.out.println("index=" + index);

		for (String i : index) { // <-- Checked card's shuffle
			int c = deckcards.remove(0);
			handcards.set(Integer.parseInt(i), c);
		}

		evaluate();
		buttonLabel = "次のゲーム";
	}

	/** 役の判別を行い、チップを増減させる */
	public void evaluate() {
		int red = countRed();
		int seven = countSeven();
		int point = 0;
		countNumber();
		if (isStraight && isFlush && (count[12] == 1)) {
			message = "ロイヤルストレートフラッシュ";
			point = 400;
		} else if (isStraight && isFlush) {
			message = "ストレートフラッシュ";
			point = 300;
		} else if(four == 1) {
			message = "フォーカード";
			point = 250;
		} else if (three == 1 && two == 1){
			message = "フルハウス";
			point = 200;
		} else if (three == 1) {
			message = "スリーカード";
			point = 170;
		} else if (isFlush) {
			point = 150;
			message = "フラッシュ";
		} else if (isStraight) {
			message = "ストレート";
			point = 130;
		} else if (two == 2) {
			message = "ツーペア";
			point = 100;
		} else if (two == 1) {
			message = "ワンペア";
			point = 50;
		} else if (red == 5) {
			message = "レッド";
			point = 50;
		} else if (seven > 0) {
			message = "セブン";
			point = seven * 10;
		} else {
			message = "ハイカード";
			point = -100;
		}
		chips += point;
		message += ": " + chips;
	}

	int countSeven() {
		int num = 0;
		for (int id : handcards) {
			if ((id == 7) || (id == 20) || (id == 33) || (id == 46)) {
				num += 1;
			}
		}
		return num;
	}

	int countRed() {
		int num = 0;
		for (int id : handcards) {
			if ((id <= 14) || (39 <= id)) {
				num += 1;
			}
		}
		return num;
	}

	void countNumber() {
		count = new int[13];
		suit = new int[4];
		for (int id : handcards) {
			count[(id - 1) % 13] += 1;
			suit[(int)(Math.floor((id - 1) - 1) / 13)] +=1;
		}
		two = 0;
		three = 0;
		four = 0;
		for (int n : count) {
			switch (n) {
			case 2:
				two += 1;
				break;
			case 3:
				three += 1;
				break;
			case 4:
				four += 1;
				break;
			default:
				break;
			}
			System.out.print(n + " ");
		}
		int tmp = 0;
		isStraight = false;
		for (int i = 0; i < 13; i++) {
			if (count[i] == 1) {
				if (tmp == 0) {
					tmp += 1;
				} else if (count[i - 1] == 1) {
					tmp += 1;
				}
			}
		}
		if (tmp == 5) {
			isStraight = true;
			System.out.println("Straight");
		}
		isFlush = false;
		for (int suit: suit) {
			if (suit == 5) {
				isFlush = true;
			}
		}
		System.out.println();
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

	public void setHandcards(int a, int b, int c, int d, int e) {
		handcards.set(0, a);
		handcards.set(1, b);
		handcards.set(2, c);
		handcards.set(3, d);
		handcards.set(4, e);
	}
}