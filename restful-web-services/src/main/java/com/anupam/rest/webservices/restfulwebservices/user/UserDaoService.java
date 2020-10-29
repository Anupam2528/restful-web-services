package com.anupam.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	static{
		
		users.add(new User(1, "India", new Date()));
		users.add(new User(2, "Canada", new Date()));
		users.add(new User(3, "Germany", new Date()));
		
		
	}
	
	//findAll
	//save
	//findOne
	
	public  List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		
		users.add(user);
		return user;
	}
	
	public User findOne(int id){
		for (User user : users) {
			if(user.getId() == id){
				return user;
			}
		}
		return new User(0, "User not found", new Date());
	}
	
	
	
}
