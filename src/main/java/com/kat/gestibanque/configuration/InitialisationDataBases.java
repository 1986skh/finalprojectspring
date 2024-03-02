package com.kat.gestibanque.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.kat.gestibanque.entities.ERole;
import com.kat.gestibanque.entities.Role;
import com.kat.gestibanque.repository.RoleRepository;

import jakarta.annotation.PostConstruct;

@Configuration
public class InitialisationDataBases {

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    private void initRole() {
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(ERole.USER));
            roleRepository.save(new Role(ERole.ADMIN));
            roleRepository.save(new Role(ERole.AGENT));
            roleRepository.save(new Role(ERole.CLIENT));
        }
    }
}