package com.kat.gestibanque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kat.gestibanque.entities.Services;
import com.kat.gestibanque.services.ServService;

@RequestMapping("/services")
@RestController
@CrossOrigin("*")
public class ServController {

	
	@Autowired ServService servService;

	@GetMapping("/")
	public List<Services> getAllServices() {
		return servService.listService();
	}

	@PostMapping("/")
	public Services addServices(@RequestBody Services services) {
		return servService.saveService(services);
	}

	@PutMapping("/")
	public Services updateServices(@RequestBody Services services) {
		return servService.saveService(services);
	}

	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable int id) {
		servService.deleteService(id);
	}
	
	@GetMapping("/{id}")
	public Services getService(@PathVariable int id) {
		return servService.getService(id);
	}
}
