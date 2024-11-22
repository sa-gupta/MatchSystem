package com.flip.dao;

import java.util.List;

import com.flip.model.User;

public interface UserDao {

	void createUsers();
	
	List<User> getAllUsers();

	User getUserByName(String name);

}
