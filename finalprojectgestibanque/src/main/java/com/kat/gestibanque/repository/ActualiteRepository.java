package com.kat.gestibanque.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kat.gestibanque.entities.Actualite;
import com.kat.gestibanque.entities.Banque;
@Repository
public interface ActualiteRepository extends CrudRepository<Actualite,Integer> {

	List<Actualite> findByTitre(String titre);
	

	
}
