package com.anupam.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path="/hello-world-bean/{name}")
	public HelloWorldBean helloWorldFromBean(@PathVariable String name){
		
		return new HelloWorldBean("Hello World from " + name);
	}
	
}
