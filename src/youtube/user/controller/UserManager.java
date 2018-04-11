package youtube.user.controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;

import youtube.user.exceptions.ExistingUserException;
import youtube.user.exceptions.WrongCredentialsException;
import youtube.user.model.User;
import youtube.user.model.UserDao;

public class UserManager {
	
	private static UserManager instance;

	public static synchronized UserManager getInstance() {
		if(instance == null) {
			instance = new UserManager();
		}
		return instance;
	}
	
	private UserManager() {
		
	}
	
	public boolean login(String username, String password) {
		try {
			UserDao.getInstance().loginCheck(username, password);
			return true;
		} catch (SQLException e) {
			System.out.println("Sori, ama ima bug: " + e.getMessage());
			return false;
		} catch (WrongCredentialsException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean register(String username, String password, String email) {
		//TODO validations
		User u = new User(username, password, email);
		try {
			//validate name, pass and email
			UserDao.getInstance().registerCheck(username, password, email);
			//check if same user exists
			UserDao.getInstance().existingUserCheck(username, email);
			UserDao.getInstance().saveUser(u);
			return true;
		} catch (SQLException e) {
			System.out.println("Sori, ama ima bug: " + e.getMessage());
			return false;
		} catch (ExistingUserException e) {
			System.out.println(e.getMessage());
			return false;
		} catch (WrongCredentialsException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Collection<User> getAll(){
		try {
			return UserDao.getInstance().getAllUsers();
		} catch (SQLException e) {
			return Collections.EMPTY_LIST;
		}
	}
}

