package poker;
public class PokerModel {
/** ゲーム回数 */
int games;
/** コンストラクタ */
public PokerModel() {
}
/** 一連のゲームを開始する */
public void reset() {
games = 0;
}
/** 次のゲームのためにカードを配りなおす */
public void nextgame() {
games++;
}
/** JSPから呼び出されるメソッド */
public int getGames() {
return games;
}
}