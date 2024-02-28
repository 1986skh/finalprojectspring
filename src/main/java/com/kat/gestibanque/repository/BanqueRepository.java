package com.kat.gestibanque.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kat.gestibanque.entities.Banque;

public interface BanqueRepository extends CrudRepository<Banque,Integer> {

	

	List<Banque> findByNomContaining(String nom);
	
}
