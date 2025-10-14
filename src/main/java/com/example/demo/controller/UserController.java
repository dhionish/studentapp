package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println("Received: " + user.getName() + ", " + user.getRole());
        return user;
    }
	
	@PostMapping("/test")
	public String testPost(@RequestBody String body) {
	    System.out.println("Raw POST received: " + body);
	    return "OK";
	}
}
