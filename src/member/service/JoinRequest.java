package member.service;



import java.util.Map;

public class JoinRequest {
	private String id;
	private String password;
	private String confirmPassword;
	private String name;
	private String nickname;
	private String birth;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public void validate(Map<String, Boolean> errors) {
		// id값이 잘 들어 왔는지?
		checkEmpty(errors, id, "id");
		// name 잘 들어왔는지?
		checkEmpty(errors, name, "name");
		// password 잘 들어왔는지?
		checkEmpty(errors, password, "password");
		// confirmPw 잘 들어왔는지 ?
		checkEmpty(errors, confirmPassword, "confirmPassword");
		// 닉네임 체크
		checkEmpty(errors, nickname, "nickname");
		// 생년월일 체크
		checkEmpty(errors, birth, "birth");

		if (!errors.containsKey("confirmPassword")) {
			if (!isPasswordEqualToConfirm()) {
				errors.put("notMatch", true);
			}
		}
	}

	
		
	
	
	public boolean isPasswordEqualToConfirm() {
		return password != null && password.equals(confirmPassword);
	}
	

	private void checkEmpty(Map<String, Boolean> errors, String value, String fieldName) {
		if (value == null || value.isEmpty()) {
			errors.put(fieldName, true);
		}
	}
	
	
}
