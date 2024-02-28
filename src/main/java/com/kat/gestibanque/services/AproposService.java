package com.kat.gestibanque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.gestibanque.entities.Apropos;

import com.kat.gestibanque.repository.AproposRepository;

@Service
public class AproposService {

		@Autowired
		AproposRepository aproposRepository;

		public List<Apropos>listApropos() {
			return (List<Apropos>) aproposRepository.findAll();		
		}
		public Apropos saveApropos(Apropos apropos) {  // cette méthode sert aussi bien pour l'ajout ou la modification
			return aproposRepository.save(apropos);
		}		
		public void deleteApropos(int id) {
			aproposRepository.deleteById(id);
		}		
		public Apropos getApropos(int id) {
			return aproposRepository.findById(id).get();
		}
	}

	

