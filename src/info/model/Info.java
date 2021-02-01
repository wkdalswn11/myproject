package info.model;


import java.util.Date;

public class Info {
	private Integer number;
	private Writer writer;
	private String title;
	private Date regdate;
	private Date moddate;
	private int read;
	private int love;
	private int hate;
	
	public Info(Integer number, Writer writer, String title, Date regdate, Date moddate,int read, int love, int hate) {
		super();
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regdate = regdate;
		this.moddate = moddate;
		this.read = read;
		this.love = love;
		this.hate = hate;
	}
	
	public int getRead() {
		return read;
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

	public int getLove() {
		return love;
	}

	public int getHate() {
		return hate;
	}
	
	
	
}
