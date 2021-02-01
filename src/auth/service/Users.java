package auth.service;

public class Users {
	private String id;
	private String name;
	private String password;
	
	
	public Users(String id, String name, String password) {
		super();
	
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	
	
	
	
	
}
