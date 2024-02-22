package com.kat.gestibanque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kat.gestibanque.entities.Apropos;
import com.kat.gestibanque.entities.Contact;
import com.kat.gestibanque.services.AproposService;
import com.kat.gestibanque.services.ContactService;

@RequestMapping("/contact")
@RestController
@CrossOrigin("*")
public class ContactController {

	
	@Autowired ContactService contactService;

	@GetMapping("/")
	public List<Contact> getAllContactService() {
		return contactService.listContact();
	}

	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact) {
		return contactService.saveContact(contact);
	}

	@PutMapping("/")
	public Contact updateContact(@RequestBody Contact contact) {
		return contactService.saveContact(contact);
	}

	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable int id) {
		contactService.deleteContact(id);
	}
	
	@GetMapping("/{id}")
	public Contact getContact(@PathVariable int id) {
		return contactService.getContact(id);
	}
}
