package snack.service;

import java.util.Map;

public class ModifySnackRequest {
	private String userId;
	private Integer snackNo;
	private String title;
	private String content;
	
	public ModifySnackRequest(String userId, Integer snackNo, String title, String content) {
		super();
		this.userId = userId;
		this.snackNo = snackNo;
		this.title = title;
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public Integer getSnackNo() {
		return snackNo;
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
