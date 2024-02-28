package com.kat.gestibanque.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kat.gestibanque.entities.ERole;
import com.kat.gestibanque.entities.Role;
import com.kat.gestibanque.entities.User;
import com.kat.gestibanque.jwt.JwtUtils;
import com.kat.gestibanque.models.request.LoginRequest;
import com.kat.gestibanque.models.request.SignupRequest;
import com.kat.gestibanque.models.response.JwtResponse;
import com.kat.gestibanque.models.response.MessageResponse;
import com.kat.gestibanque.repository.RoleRepository;
import com.kat.gestibanque.repository.UserRepository;
import com.kat.gestibanque.services.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

 
  @Autowired
  PasswordEncoder encoder;
  
  @Autowired
  JwtUtils jwtUtils;
  
 
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	  
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();  // Ce qu'on récupère du Request
    
    Set<Role> roles = new HashSet<>(); // ce qu'on doit créer et sauvegarder dans la base pour chaque User

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "client":
          Role clientRole = roleRepository.findByName(ERole.CLIENT)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(clientRole);

          break;
        case "agent":
            Role agentRole = roleRepository.findByName(ERole.AGENT)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(agentRole);
          break;          
          
        default:
          Role userRole = roleRepository.findByName(ERole.USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("Inscription avec succès!"));
  }

  
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	  //1-get Authentication
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

     //2-get token
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    //3-get User details
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    
     //4-get roles
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
  }

}