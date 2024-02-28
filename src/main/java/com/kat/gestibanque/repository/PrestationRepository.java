package com.kat.gestibanque.repository;

import org.springframework.data.repository.CrudRepository;

import com.kat.gestibanque.entities.Prestation;

public interface PrestationRepository extends CrudRepository<Prestation,Integer> {

}
