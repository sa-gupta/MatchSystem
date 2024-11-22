package com.flip.service;

import java.util.List;

import com.flip.model.User;

public interface UserService {

	void createUsers();
	
	List<User> getAllUsers();
	
	User getUserByName(String name) throws Exception;

	List<User> findMatch(String inputtedName);

}
