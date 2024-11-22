package com.flip.main;

import java.util.List;
import java.util.Scanner;

import com.flip.model.User;
import com.flip.service.UserService;
import com.flip.service.UserServiceImpl;

public class Main {


	private UserService userService;

	public Main() {
		userService = new UserServiceImpl();
	}
	
	private void execute() {
		userService.createUsers();
		Scanner scan = new Scanner(System.in);
		String inputtedName = readFromConsole(scan);
		List<User> matchedUsers = userService.findMatch(inputtedName);
		if(!matchedUsers.isEmpty()) {
			System.out.println("Matched users: ");
			matchedUsers.stream().forEach(u -> System.out.println(u.getName()));
		}else {
			System.out.println("No match found!!");
		}
	}
	
	private String readFromConsole(Scanner scan) {
		System.out.println("Enter name: ");
		String input = scan.next();
		return input;
		
	}

	public static void main(String[] args) {
		new Main().execute();

	}

}
