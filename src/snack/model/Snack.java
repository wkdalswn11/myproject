package snack.model;

import java.util.Date;

import info.model.Writer;

public class Snack {
	private Integer number;
	private Writer writer;
	private String title;
	private Date regdate;
	private Date moddate;
	private int readConunt;
	private int good;
	private int hate;
	
	public Snack(Integer number, Writer writer, String title, Date regdate, Date moddate, int readConunt, int good,
			int hate) {
		super();
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regdate = regdate;
		this.moddate = moddate;
		this.readConunt = readConunt;
		this.good = good;
		this.hate = hate;
	}

	public Integer getNumber() {
		return number;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public Date getRegdate() {
		return regdate;
	}

	public Date getModdate() {
		return moddate;
	}

	public int getReadConunt() {
		return readConunt;
	}

	public int getGood() {
		return good;
	}

	public int getHate() {
		return hate;
	}
	
	
	
	
	
}
