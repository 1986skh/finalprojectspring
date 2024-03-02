package com.kat.gestibanque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kat.gestibanque.entities.User;
import com.kat.gestibanque.services.UserDetailsServiceImpl;
@RestController
@RequestMapping({ "/users" })
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserDetailsServiceImpl userService;

	@GetMapping
	public List<User> findAll() {
		return (List<User>) userService.getAllUsers();
	}
	
	@RequestMapping({ "/agents" })
	@GetMapping
	public List<User> findAllAgents() {
		return (List<User>) userService.getAllAgents();
	}
    @PostMapping("/addAgent")
    public User addAgent(@RequestBody User agent) {
    return userService.addAgent(agent);
    }
	
	@DeleteMapping("/{UserId}")
	public User deleteUser(@PathVariable Long UserId) {
		return userService.delete(UserId);
	}

}
