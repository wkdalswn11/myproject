package info.service;

import info.model.Info;

public class InfoLove {
	private Info info;
	private int love;
	
	public InfoLove(Info info, int love) {
		super();
		this.info = info;
		this.love = love;
	}

	public Info getInfo() {
		return info;
	}

	public int getLove() {
		return love;
	}
	
	
	
}
