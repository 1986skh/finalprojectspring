package com.kat.gestibanque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.gestibanque.entities.Actualite;
import com.kat.gestibanque.repository.ActualiteRepository;

@Service
public class ActualiteService {

	@Autowired
	ActualiteRepository actualiterepository;

	public List<Actualite> listActualite() {
		return (List<Actualite>) actualiterepository.findAll();
	}
	
	public Actualite saveActualite(Actualite actualite) { 
		return actualiterepository.save(actualite);
	}
	
	public void deleteActualite(int id) {
		actualiterepository.deleteById(id);
	}
	
	public Actualite getActualite(int id) {
		return actualiterepository.findById(id).get();
	}
}
