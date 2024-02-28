package com.kat.gestibanque.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.gestibanque.entities.CompteBancaire;
import com.kat.gestibanque.repository.CompteBancaireRepository;

@Service
public class CompteBancaireService {
	@Autowired
	CompteBancaireRepository compteBancaireRepository;
public List<CompteBancaire>listcompteBancaire(){
	return (List<CompteBancaire>)compteBancaireRepository.findAll();
}
public CompteBancaire saveCompteBancaire(CompteBancaire comptes) {
	return compteBancaireRepository.save(comptes);

}

public void deleteCompteBancaire(int id) {
	compteBancaireRepository.deleteById(id);
}

public CompteBancaire getCompteBancaire(int id) {
	return compteBancaireRepository.findById(id).get();
}
public CompteBancaire chercher(String numeroCompte) {
    return compteBancaireRepository.findByNumeroCompte(numeroCompte);
}
}
