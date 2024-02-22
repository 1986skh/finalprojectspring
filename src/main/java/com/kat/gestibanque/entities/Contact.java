package com.kat.gestibanque.entities;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contact {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String titre;
	private String messages;
	private String nom;
	private String email;
	
	
	public Contact() {
		
	}
	
	public Contact(int contactId, String titre, String messages, String nom, String email) {
		super();
		this.id = id;
		this.titre = titre;
		this.messages = messages;
		this.nom = nom;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + id + ", titre=" + titre + ", messages=" + messages + ", nom=" + nom
				+ ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
