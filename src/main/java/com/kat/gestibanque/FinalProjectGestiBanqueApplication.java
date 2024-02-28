package com.kat.gestibanque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.kat.gestibanque.repository.RoleRepository;

import jakarta.annotation.PostConstruct;
import com.kat.gestibanque.entities.*;




@SpringBootApplication
public class FinalProjectGestiBanqueApplication{
	
	@Autowired
	  RoleRepository roleRepository;
	
	/*@PostConstruct
	private void initRole()  {
		roleRepository.save(new Role(ERole.USER));
		roleRepository.save(new Role(ERole.ADMIN));
		roleRepository.save(new Role(ERole.AGENT));
		roleRepository.save(new Role(ERole.CLIENT));
	}*/

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectGestiBanqueApplication.class, args);
	}

}
