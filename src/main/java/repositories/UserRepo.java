package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.Privilege;
import domain.User;

public class UserRepo implements UserRepoInterface{

	private static List<User> db = new ArrayList<User>();
	
	public UserRepo() {
		if (db.isEmpty()) {
			User user1 = new User();
			user1.setUsername("Grzegorz");
			user1.setPassword("456");
			user1.setEmail("grzegorzzukowski@gmail.com");
			user1.setPrivilege(Privilege.ADMIN);
			
			User user2 = new User();
			user2.setUsername("Marian");
			user2.setPassword("456");
			user2.setEmail("marian.piekny@gmail.com");
			user2.setPrivilege(Privilege.NORMAL);
			
			User user3 = new User();
			user3.setUsername("Seba");
			user3.setPassword("456");
			user3.setEmail("sebatumolec@gmail.com");
			user3.setPrivilege(Privilege.PREMIUM);
			
			db.add(user1);
			db.add(user2);
			db.add(user3);
		}
	}

	public void add (User user) {
		db.add(user);
	}
	
	public boolean login (User user) {
		for (User userDb : db) {
			if (userDb.getUsername().
					equals(user.getUsername()) && userDb.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public List<User> getAllUsers() {
		return db;
	}
	
	public String getEmail(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				return userDb.getEmail();
			}
		}
		return "Nie ma takiego urzytkownika";
	}
	
	public String getPrivilege(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				return userDb.getPrivilege().toString();
			}
		}
		return "Nie ma takiego urzytkownika";
	}
	
	public void grantPremium(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				userDb.setPrivilege(Privilege.PREMIUM);
			}
		}
	}
	
	public void revokePremium(User user) {
		for (User userDb : db) {
			if (userDb.getUsername().equals(user.getUsername())) {
				userDb.setPrivilege(Privilege.NORMAL);
			}
		}
	}
}
