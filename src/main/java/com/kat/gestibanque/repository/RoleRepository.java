package com.kat.gestibanque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kat.gestibanque.entities.ERole;
import com.kat.gestibanque.entities.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
 
	Optional<Role> findByName(ERole name);
}