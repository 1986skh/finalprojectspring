package com.kat.gestibanque.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kat.gestibanque.entities.Actualite;
import com.kat.gestibanque.exceptions.ResourceNotFoundException;
import com.kat.gestibanque.repository.ActualiteRepository;


@Service
public class ActualiteService {

	@Autowired
	ActualiteRepository actualiteRepository;

	public List<Actualite> listActualite() {
	return (List<Actualite>) actualiteRepository.findAll();
	}
	
	//public Actualite saveActualite(Actualite actualite) {  // cette méthode sert aussi bien pour l'ajout ou la modification
	//	return actualiteRepository.save(actualite);	}
	private final Path root = Paths.get(System.getProperty("user.dir") + "/src/main/resources/static/uploads");
	

/*	public Banque saveBanque(Banque banque) { 
		return banqueRepository.save(banque);
	}	*/	
	public Actualite create(MultipartFile file, String titre, String description, LocalDate date) throws IOException {
		// generate new Random image name
		String newImageName = getSaltString().concat(file.getOriginalFilename());
		try {
			Files.copy(file.getInputStream(), this.root.resolve(newImageName)); // upload de l'image
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
		Actualite actualite = new Actualite(newImageName,titre, description, date);
		actualiteRepository.save(actualite);
		return actualite;
	}
	public Actualite delete(int actualiteId) {
		return actualiteRepository.findById(actualiteId).map(actualite -> {
			actualiteRepository.delete(actualite);
			return actualite;
		}).orElseThrow(() -> new ResourceNotFoundException("Actualite :  " +actualiteId + " not found"));
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

	
	
	
	   public Actualite updateActualite(Actualite actualite) {
	        if (actualiteRepository.existsById(actualite.getId())) {
	            return actualiteRepository.save(actualite);
	        } else {
	            throw new ResourceNotFoundException("Actualite avec l'ID : " + actualite.getId() + " non trouvée");
	        }
	    }
	public void deleteActualite(int id) {
		actualiteRepository.deleteById(id);
	}
	
	public Actualite getActualite(int id) {
		return actualiteRepository.findById(id).get();
	}
	public List<Actualite>searchActualite(String titre) {
        return actualiteRepository.findByTitre(titre);
    }

	
}
