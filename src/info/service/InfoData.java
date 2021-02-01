package info.service;

import info.model.Info;
import info.model.InfoContent;

public class InfoData {
	private Info info;
	private InfoContent content;
	
	public InfoData(Info info, InfoContent content) {
		super();
		this.info = info;
		this.content = content;
	}

	public Info getInfo() {
		return info;
	}

	public String getContent() {
		return content.getContent();
	}
	
	
}
