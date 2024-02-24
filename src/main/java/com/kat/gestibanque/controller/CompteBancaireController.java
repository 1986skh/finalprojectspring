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

import com.kat.gestibanque.entities.CompteBancaire;
import com.kat.gestibanque.services.CompteBancaireService;


@RestController
@CrossOrigin("*")
@RequestMapping("/comptes")
public class CompteBancaireController {
	@Autowired CompteBancaireService compteBancaireService;

	@GetMapping("/")
	public List<CompteBancaire> getAllCompteBancaireService() {
		return compteBancaireService.listcompteBancaire();
	}

	@PostMapping("/")
	public CompteBancaire addCompte(@RequestBody CompteBancaire comptes) {
		return compteBancaireService.saveCompteBancaire(comptes);
	}

	@PutMapping("/")
	public CompteBancaire updateCompte(@RequestBody CompteBancaire comptes) {
		return compteBancaireService.saveCompteBancaire(comptes);
	}

	@DeleteMapping("/{id}")
	public void deleteCompte(@PathVariable int id) {
		compteBancaireService.deleteCompteBancaire(id);
	}
	
	@GetMapping("/{id}")
	public CompteBancaire getCompte(@PathVariable int id) {
		return compteBancaireService.getCompteBancaire(id);
	}
	   @GetMapping("/{numero}")
	    public CompteBancaire getCompteByNumero(@PathVariable String numeroCompte) {
	        return compteBancaireService.chercher(numeroCompte);
	    }
}
