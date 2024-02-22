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


import com.kat.gestibanque.entities.Actualite;
import com.kat.gestibanque.services.ActualiteService;

@RequestMapping("/actualite")
@RestController
@CrossOrigin("*")
public class ActualiteController {

	
	@Autowired ActualiteService actualiteService;

	@GetMapping("/")
	public List<Actualite> getAllActualite() {
		return actualiteService.listActualite();
	}

	@PostMapping("/")
	public Actualite addActualite(@RequestBody Actualite actualite) {
		return actualiteService.saveActualite(actualite);
	}

	@PutMapping("/{id}")
	public Actualite updateActualite(@PathVariable int id,@RequestBody Actualite actualite) {
		return actualiteService.saveActualite(actualite);
	}

	@DeleteMapping("/{id}")
	public void deleteActualite(@PathVariable int id) {
		actualiteService.deleteActualite(id);
	}
	
	@GetMapping("/{id}")
	public Actualite getActualite(@PathVariable int id) {
		return actualiteService.getActualite(id);
	}
}
