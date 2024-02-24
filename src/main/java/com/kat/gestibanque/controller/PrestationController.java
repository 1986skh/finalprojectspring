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

import com.kat.gestibanque.entities.Prestation;
import com.kat.gestibanque.services.PrestationService;


@RequestMapping("/prestations")
@RestController
@CrossOrigin("*")
public class PrestationController {
@Autowired PrestationService prestationService;

	@GetMapping("/")
	public List<Prestation> getAllPrestation() {
		return prestationService.listPrestation();
	}

	@PostMapping("/")
	public Prestation addPrestations(@RequestBody Prestation prestations) {
		return prestationService.savePrestation(prestations);
	}

	@PutMapping("/")
	public Prestation updatePrestations(@RequestBody Prestation prestations) {
		return prestationService.savePrestation(prestations);
	}

	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable int id) {
		prestationService.deletePrestation(id);
	}
	
	@GetMapping("/{id}")
	public Prestation getService(@PathVariable int id) {
		return prestationService.getPrestation(id);
	}
}
