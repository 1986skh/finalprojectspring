package com.kat.gestibanque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kat.gestibanque.entities.CompteBancaire;


@Repository
public interface CompteBancaireRepository extends CrudRepository<CompteBancaire,Integer>{
	 CompteBancaire findByNumero(Double numeroCompte);
}
