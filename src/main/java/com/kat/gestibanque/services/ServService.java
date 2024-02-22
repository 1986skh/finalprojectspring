package com.kat.gestibanque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.gestibanque.entities.Services;
import com.kat.gestibanque.repository.ServiceRepository;

@Service
public class ServService {
	
	@Autowired ServiceRepository serviceRepository;

	public List<Services> listService() {
		return (List<Services>) serviceRepository.findAll();		
	}
	public Services saveService(Services services) {  
		return serviceRepository.save(services);
	}		
	public void deleteService(int id) {
		serviceRepository.deleteById(id);
	}		
	public Services getService(int id) {
		return serviceRepository.findById(id).get();
	}
}
