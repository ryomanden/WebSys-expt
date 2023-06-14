package db;

import java.sql.Date;
import java.sql.Time;

/** テーブルpokemonのデータを保持するクラス */
public class Appear {
	/** ID */
	private int id;
	/** num */
	private int number;
	/** name */
	private String name;
	/** ken */
	private String ken;
	/** shi */
	private String shi;
	/** Date */
	private Date date;
	/** Time */
	private Time time;
	/** コンストラクタ */
	public Appear(int id, int number, String name, String ken, String shi, Date date, Time time) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.ken = ken;
		this.shi = shi;
		this.date = date;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String getKen() {
		return ken;
	}
	public String getShi() {
		return shi;
	}
	public Date getDate() {
		return date;
	}
	public Time getTime() {
		return time;
	}
}