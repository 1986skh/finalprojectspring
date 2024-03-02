package com.kat.gestibanque.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.gestibanque.entities.Banque;
import com.kat.gestibanque.exceptions.ResourceNotFoundException;
import com.kat.gestibanque.repository.BanqueRepository;

@Service
public class BanqueService {
	private final Path root = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/uploads");
	@Autowired BanqueRepository banqueRepository;

	public List<Banque>listBanque() {
		return (List<Banque>) banqueRepository.findAll();		
	}
/*	public Banque saveBanque(Banque banque) { 
		return banqueRepository.save(banque);
	}	*/	
	public Banque create(MultipartFile file, String nom, String adresse, double capital) throws IOException {
		// generate new Random image name
		String newImageName = getSaltString().concat(file.getOriginalFilename());
		try {
			Files.copy(file.getInputStream(), this.root.resolve(newImageName)); // upload de l'image
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
		Banque banque = new Banque(nom, adresse, newImageName, capital);
		banqueRepository.save(banque);
		return banque;
	}
	public Banque delete(int banqueId) {
		return banqueRepository.findById(banqueId).map(banque -> {
			banqueRepository.delete(banque);
			return banque;
		}).orElseThrow(() -> new ResourceNotFoundException("Banque :  " +banqueId + " not found"));
	}
	
	// rundom string to be used to the image name
		protected static String getSaltString() {
			String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			StringBuilder salt = new StringBuilder();
			Random rnd = new Random();
			while (salt.length() < 18) { // length of the random string.
				int index = (int) (rnd.nextFloat() * SALTCHARS.length());
				salt.append(SALTCHARS.charAt(index));
			}
			String saltStr = salt.toString();
			return saltStr;
		}

	public void deleteBanque(int id) {
		banqueRepository.deleteById(id);
	}		
	public Banque getBanque(int id) {
		return banqueRepository.findById(id).get();
	}
	   
	   public List<Banque> searchByNom(String nom) {
	        return banqueRepository.findByNomContaining(nom);
	    }
	   public Banque updateBanque(Banque banque) {
	        // Vérifier si la banque existe dans la base de données
	        if (banqueRepository.existsById(banque.getId())) {
	            return banqueRepository.save(banque);
	        } else {
	            throw new ResourceNotFoundException("Banque avec l'ID : " + banque.getId() + " non trouvée");
	        }
	    }
}
