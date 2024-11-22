package com.flip.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.flip.dao.UserDao;
import com.flip.dao.UserDaoImpl;
import com.flip.model.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	
	@Override
	public void createUsers() {
		userDao.createUsers();
		
	}


	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}


	@Override
	public List<User> findMatch(String inputtedName)  {
		List<User> potentialUsers = new ArrayList<User>();
		try {
			User user = getUserByName(inputtedName);
			List<User> allUsers = userDao.getAllUsers();
			
			for (User currUser : allUsers) {
				Integer ageGap = Math.abs(currUser.getAge()-user.getAge());
				if(ageGap<10 && !currUser.getName().equalsIgnoreCase(inputtedName) && !currUser.getGender().equals(user.getGender())) {
					potentialUsers.add(currUser);
				}
			}
			
			Collections.sort(potentialUsers, new Comparator<User>() {

				@Override
				public int compare(User o1, User o2) {
					int age1 = Math.abs(user.getAge()-o1.getAge());
					int age2 = Math.abs(user.getAge()-o2.getAge());
					if(age1 != age2) {
						return Integer.compare(age1, age2);
					}
					
					int cityPrior = user.getCity().equalsIgnoreCase(o1.getCity()) ? -1 : 1;
					if(cityPrior != 0) {
						return cityPrior;
					}
					String currGender = user.getGender().toString();
					String o1gender = o1.getGender().toString();
					int genderPrior = currGender.equalsIgnoreCase(o1gender) ? 1 : -1;
					
					return genderPrior;
				}
				
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return potentialUsers;
	}


	@Override
	public User getUserByName(String name) throws Exception {
		User user = userDao.getUserByName(name);
		if(user == null) {
			throw new Exception("User not found!!");
		}
		return user;
	}

}
