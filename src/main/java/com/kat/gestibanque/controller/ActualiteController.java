package com.kat.gestibanque.controller;

import java.io.IOException;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kat.gestibanque.entities.Actualite;
import com.kat.gestibanque.entities.Apropos;
import com.kat.gestibanque.entities.Banque;
import com.kat.gestibanque.services.ActualiteService;


@RequestMapping("/actualites")


@RestController
@CrossOrigin("*")
public class ActualiteController {

	
	@Autowired ActualiteService actualiteService;

	@GetMapping("/")
	public List<Actualite> getAllActualite() {
		return actualiteService.listActualite();
	}

	@PostMapping("/")
//	public Actualite addActualite(@RequestBody Actualite actualite) {
//		return actualiteService.saveActualite(actualite);}
	public Actualite create(@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("titre") String titre,
			@RequestParam("description") String description, 
			@RequestParam("date") LocalDate date
			//@RequestParam("imageName") String imageName
			) throws IOException, Throwable
	{
		
		//System.out.println("Hello");
		return actualiteService.create(imageFile,titre,description,date);
	}

	@PutMapping("/{id}")
	public Actualite updateActualite(@RequestBody Actualite actualite) {
	    return actualiteService.updateActualite(actualite);
	}
	@DeleteMapping("/{id}")
	public void deleteActualite(@PathVariable int id) {
		actualiteService.deleteActualite(id);
	}
	
	@GetMapping("/{id}")
	public Actualite getActualite(@PathVariable int id) {
		return actualiteService.getActualite(id);
	}
	
	 @GetMapping("/search")
	    public List<Actualite>searchActualite(@RequestParam String titre) {
	        return actualiteService.searchActualite(titre);
	    }

	
}
