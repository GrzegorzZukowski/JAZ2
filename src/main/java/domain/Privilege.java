package domain;

public enum Privilege {
	NORMAL("normal"),
	PREMIUM("premium"), 
	ADMIN("admin");
	
	private final String name;
	
	private Privilege(String privilege) {
		name = privilege;
	}
	
	public String getValue() {
		return name;
	}
}
