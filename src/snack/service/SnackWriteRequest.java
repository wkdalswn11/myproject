package snack.service;

import java.util.Map;

import info.model.Writer;

public class SnackWriteRequest {
	private Writer writer;
	private String title;
	private String content;
	
	public SnackWriteRequest(Writer writer, String title, String content) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.isEmpty()) {
			errors.put("title", Boolean.TRUE);
			
		}
		
	}
	
	
	
}
