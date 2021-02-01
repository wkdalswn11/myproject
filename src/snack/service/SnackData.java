package snack.service;

import snack.model.Snack;
import snack.model.SnackContent;

public class SnackData {
	private Snack snack;
	private SnackContent content;
	
	public SnackData(Snack snack, SnackContent content) {
		super();
		this.snack = snack;
		this.content = content;
	}

	public Snack getSnack() {
		return snack;
	}

	public String getContent() {
		return content.getContent();
	}
	
	
	
}
