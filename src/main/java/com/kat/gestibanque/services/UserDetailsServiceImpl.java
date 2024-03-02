package com.kat.gestibanque.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kat.gestibanque.exceptions.ResourceNotFoundException;
import com.kat.gestibanque.entities.ERole;
import com.kat.gestibanque.entities.Role;
import com.kat.gestibanque.entities.User;
import com.kat.gestibanque.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllAgents() {
        List<User> users = userRepository.findAll();
        List<User> agents = new ArrayList<>();
        for (User user : users) {
            Set<Role> roles = user.getRoles();
            for (Role role : roles) {
                if (role.getName().equals(ERole.AGENT)) {
                    agents.add(user);
                }
            }
        }
        return agents;
    }

    public User addAgent(User agent) {
        // Vérifier si l'agent existe déjà dans la base de données
        if (userRepository.existsByUsername(agent.getUsername())) {
            throw new RuntimeException("Username already exists!");
        }
        if (userRepository.existsByEmail(agent.getEmail())) {
            throw new RuntimeException("Email already exists!");
        }
        
        // Définir le rôle de l'agent comme "AGENT"
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(ERole.AGENT));
        agent.setRoles(roles);
        
        // Sauvegarder l'agent dans la base de données
        return userRepository.save(agent);
    }

    public User delete(Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return user;
                }).orElseThrow(() -> new ResourceNotFoundException("User : " + userId + " not found"));
    }
}