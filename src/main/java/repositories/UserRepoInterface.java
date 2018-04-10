package repositories;

import java.util.List;

import domain.User;

public interface UserRepoInterface {
	
	void add (User user);
	boolean login(User uer);
	List<User> getAllUsers();
	String getEmail(User user);
	String getPrivilege(User user);
	void grantPremium (User user);
	void revokePremium (User user);
}
