package com.flip.dao;

import java.util.ArrayList;
import java.util.List;

import com.flip.model.Gender;
import com.flip.model.User;

public class UserDaoImpl implements UserDao {

	private List<User> users = new ArrayList<User>();
	
	@Override
	public void createUsers() {
		User user1 = new User("John",Gender.MALE,27,"Boston");
		User user2 = new User("Maria",Gender.FEMALE,25,"Seattle");
		User user3 = new User("Harry",Gender.MALE,38,"Chicago");
		User user4 = new User("Julia",Gender.FEMALE,22,"New york");
		User user5 = new User("Sara",Gender.FEMALE,22,"Boston");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		
		
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public User getUserByName(String name) {
		for (User user : users) {
			if(user.getName().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

}
