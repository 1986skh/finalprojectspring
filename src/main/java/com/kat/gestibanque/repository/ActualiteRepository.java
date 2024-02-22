package com.kat.gestibanque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kat.gestibanque.entities.Actualite;
@Repository
public interface ActualiteRepository extends CrudRepository<Actualite,Integer> {

}
