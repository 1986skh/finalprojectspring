package com.kat.gestibanque.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.gestibanque.entities.Actualite;
import com.kat.gestibanque.repository.ActualiteRepository;

@Service
public class ActualiteService {

	@Autowired
	ActualiteRepository actualiteRepository;

	public List<Actualite> listActualite() {
		return (List<Actualite>) actualiteRepository.findAll();
	}
	
	public Actualite saveActualite(Actualite actualite) {  // cette méthode sert aussi bien pour l'ajout ou la modification
		return actualiteRepository.save(actualite);
	}
	
	public void deleteActualite(int id) {
		actualiteRepository.deleteById(id);
	}
	
	public Actualite getActualite(int id) {
		return actualiteRepository.findById(id).get();
	}
	
	
}
