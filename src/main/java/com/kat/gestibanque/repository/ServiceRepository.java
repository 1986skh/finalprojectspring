package com.kat.gestibanque.repository;

import org.springframework.data.repository.CrudRepository;

import com.kat.gestibanque.entities.Services;

public interface ServiceRepository extends CrudRepository<Services,Integer> {

}
