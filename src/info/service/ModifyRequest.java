package info.service;

import java.util.Map;

public class ModifyRequest {
	private String userId;
	private Integer infoNo;
	private String title;
	private String content;
	
	public ModifyRequest(String userId, Integer infoNo, String title, String content) {
		super();
		this.userId = userId;
		this.infoNo = infoNo;
		this.title = title;
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public Integer getInfoNo() {
		return infoNo;
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
