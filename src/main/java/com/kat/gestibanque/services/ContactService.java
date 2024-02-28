package com.kat.gestibanque.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kat.gestibanque.entities.Contact;
import com.kat.gestibanque.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
ContactRepository contactRepository;

	public List<Contact>listContact() {
		return (List<Contact>) contactRepository.findAll();		
	}
	public Contact saveContact(Contact contact) {  // cette méthode sert aussi bien pour l'ajout ou la modification
		return contactRepository.save(contact);
	}		
	public void deleteContact(int id) {
		contactRepository.deleteById(id);
	}		
	public Contact getContact(int id) {
		return contactRepository.findById(id).get();
	}
}
