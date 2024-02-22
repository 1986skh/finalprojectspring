package com.kat.gestibanque.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Services {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String libelle;
	private String description;
	
	public Services(){
	
	}
	
	public Services(int idService, String libelle, String description) {
		super();
		this.id = idService;
		this.libelle = libelle;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Services [id=" + id + ", libelle=" + libelle + ", description=" + description + "]";
	}

	public int getId() {
		return id;
	}

	public void setIdService(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
