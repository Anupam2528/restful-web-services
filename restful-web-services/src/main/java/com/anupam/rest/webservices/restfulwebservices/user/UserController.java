package com.anupam.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	private UserDaoService service;
	//retriveAllUsers
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAll();
	}
	
	//retriveUser id = ?
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id){
		
		return service.findOne(id);
	}
	
	//saveUser
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user){
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(savedUser.getId()).
				toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
