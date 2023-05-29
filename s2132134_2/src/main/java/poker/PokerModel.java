package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerModel {
	int games, chips;
	int count[], suit[];
	int two, three, four;
	boolean isStraight, isFlush;
	String buttonLabel, message;

	/* __ CONSTRUCTOR __ */
	public PokerModel() {
		deckcards = new ArrayList<>();
		handcards = new ArrayList<>();
	}

	// reset game
	public void reset() {
		// reset score
		games = 0;
		chips = 500;
	}

	// next game
	public void nextgame() {

		// new deckcard
		deckcards.clear();
		for (int i = 1; i <= 52; i++) {
			deckcards.add(i);
		}
		Collections.shuffle(deckcards);

		// reset and new handcard
		handcards.clear();
		for (int i = 0; i < 5; i++) {
			int n = deckcards.remove(0);
			handcards.add(n);
		}

		/* -- below is print deckcards in console -- */
		System.out.printf("deckcards %d: ", deckcards.size());
		for (int n : deckcards) {
			System.out.printf("%d ", n);
		}
		System.out.println();

		// change message and button label
		message = "交換するカードを選択してください";
		buttonLabel = "交換";
		games ++; // <-- game count
	}

	public void change(List<String> index) {
		System.out.println("index=" + index);

		/* -- below is selected card's shuffle -- */
		for (String i : index) {
			int c = deckcards.remove(0);
			handcards.set(Integer.parseInt(i), c);
		}

		evaluate();
		buttonLabel = "次のゲーム";
	}

	// evaluate handcards and judge point
	public void evaluate() {
		int red = countRed();
		int seven = countSeven();
		int point = 0;
		countNumber();

		/* -- below is judge hand & add(reduce) chip -- */
		if (isStraight && isFlush && (count[12] == 1)) {
			message = "ロイヤルストレートフラッシュ";
			point = 400;
		} else if (isStraight && isFlush) {
			message = "ストレートフラッシュ";
			point = 300;
		} else if (four == 1) {
			message = "フォーカード";
			point = 250;
		} else if (three == 1 && two == 1) {
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
		message += ": " + point + "pt";
		if (chips <= 0) {
			message = "ゲームオーバー";
			System.out.println("Game OVER");
		}
	}

	// count "7"
	int countSeven() {
		int num = 0;
		for (int id : handcards) {
			if ((id == 7) || (id == 20) || (id == 33) || (id == 46)) {
				num++;
			}
		}
		return num;
	}

	// count "red"
	int countRed() {
		int num = 0;
		for (int id : handcards) {
			if ((id <= 14) || (39 <= id)) {
				num ++;
			}
		}
		return num;
	}

	// count number of cards
	void countNumber() {
		count = new int[13];
		suit = new int[4];
		for (int id : handcards) {
			count[(id - 1) % 13] ++;
			suit[(int) (Math.floor((id - 1) - 1) / 13)] += 1;
		}
		two = 0;
		three = 0;
		four = 0;
		for (int n : count) {
			switch (n) {
			case 2:
				two ++;
				break;
			case 3:
				three ++;
				break;
			case 4:
				four ++;
				break;
			default:
				break;
			}
			System.out.print(n + " ");
		}

		// judge "Straight"
		int tmp = 0;
		isStraight = false;
		for (int i = 0; i < 13; i++) {
			if (count[i] == 1) {
				if (tmp == 0) {
					tmp ++;
				} else if (count[i - 1] == 1) {
					tmp ++;
				}
			}
		}
		if (tmp == 5) {
			isStraight = true;
			System.out.println("Straight");
		}

		// judge "Flush"
		isFlush = false;
		for (int suit : suit) {
			if (suit == 5) {
				isFlush = true;
				System.out.println("Flush");
			}
		}
		System.out.println();
	}

	public int getGames() {
		return games;
	}

	List<Integer> deckcards;
	List<Integer> handcards;

	// return chip count
	public int getChips() {
		return chips;
	}

	// return handcards
	public int getHandcardAt(int i) {
		return handcards.get(i);
	}

	// return button label
	public String getButtonLabel() {
		return buttonLabel;
	}

	// return status message
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