package com.kat.gestibanque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.gestibanque.entities.Prestation;
import com.kat.gestibanque.repository.PrestationRepository;

@Service
public class PrestationService {
	
	@Autowired PrestationRepository prestationRepository;

	public List<Prestation> listPrestation() {
		return (List<Prestation>) prestationRepository.findAll();		
	}
	public Prestation savePrestation(Prestation prestations) {  
		return prestationRepository.save(prestations);
	}		
	public void deletePrestation(int id) {
		prestationRepository.deleteById(id);
	}		
	public Prestation getPrestation(int id) {
		return prestationRepository.findById(id).get();
	}
}
