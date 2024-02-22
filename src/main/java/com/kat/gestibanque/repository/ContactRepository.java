package com.kat.gestibanque.repository;

import org.springframework.data.repository.CrudRepository;

import com.kat.gestibanque.entities.Contact;

public interface ContactRepository extends CrudRepository<Contact,Integer> {

}
