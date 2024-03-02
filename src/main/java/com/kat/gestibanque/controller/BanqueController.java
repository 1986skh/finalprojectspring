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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kat.gestibanque.entities.Banque;
import com.kat.gestibanque.entities.Contact;
import com.kat.gestibanque.services.BanqueService;
import com.kat.gestibanque.services.ContactService;

import java.io.IOException;

@RequestMapping("/banques")
@RestController
@CrossOrigin("*")
public class BanqueController {

	
	@Autowired BanqueService banqueService;

	@GetMapping("/")
	public List<Banque> getAllBanque() {
		return banqueService.listBanque();
	}

	@PostMapping("/")
//	public Banque addBanque(@RequestBody Banque banque) {
//	return banqueService.saveBanque(banque);}
	public Banque create(@RequestParam("imageFile") MultipartFile imageFile,
			@RequestParam("nom") String nom,
			@RequestParam("adresse") String adresse, 
			@RequestParam("capital") double capital
			//@RequestParam("imageName") String imageName
			) throws IOException, Throwable
	{
		
		//System.out.println("Hello");
		return banqueService.create(imageFile,nom,adresse,capital);
	}
	@PutMapping("/")
	public Banque updateBanque(@RequestBody Banque banque) {
	    return banqueService.updateBanque(banque);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBanque(@PathVariable int id) {
		banqueService.deleteBanque(id);
	}
	
	@GetMapping("/{id}")
	public Banque getBanque(@PathVariable int id) {
		return banqueService.getBanque(id);
	}
	
	 @GetMapping("/search")
	    public List<Banque> searchBanques(@RequestParam String nom) {
	        return banqueService.searchByNom(nom);
	    }
}
