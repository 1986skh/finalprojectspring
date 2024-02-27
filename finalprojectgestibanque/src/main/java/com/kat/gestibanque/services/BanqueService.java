package com.kat.gestibanque.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.gestibanque.entities.Banque;
import com.kat.gestibanque.repository.BanqueRepository;

@Service
public class BanqueService {
	@Autowired BanqueRepository banqueRepository;

	public List<Banque>listBanque() {
		return (List<Banque>) banqueRepository.findAll();		
	}
	public Banque saveBanque(Banque banque) { 
		return banqueRepository.save(banque);
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
}
