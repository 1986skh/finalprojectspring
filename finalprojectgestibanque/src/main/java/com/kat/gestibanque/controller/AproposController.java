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

import com.kat.gestibanque.entities.Apropos;
import com.kat.gestibanque.services.AproposService;



@RequestMapping("/apropos")
@RestController
@CrossOrigin("*")
public class AproposController {
	
	@Autowired AproposService aproposService;

	@GetMapping("/")
	public List<Apropos> getAllApropos() {
		return aproposService.listApropos();
	}

	@PostMapping("/")
	public Apropos addApropos(@RequestBody Apropos apropos) {
		return aproposService.saveApropos(apropos);
	}

	@PutMapping("/")
	public Apropos updateApropos(@RequestBody Apropos apropos) {
		return aproposService.saveApropos(apropos);
	}

	@DeleteMapping("/{id}")
	public void deleteApropos(@PathVariable int id) {
		aproposService.deleteApropos(id);
	}
	
	@GetMapping("/{id}")
	public Apropos getApropos(@PathVariable int id) {
		return aproposService.getApropos(id);
	}
}
