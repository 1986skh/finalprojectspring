package com.kat.gestibanque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Banque {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String adresse;
	private double capital;
	private String telephone;
	
	public Banque() {
	
	}
	
	public Banque(int id, String nom, String adresse, double capital, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.capital = capital;
		this.telephone = telephone;
	}
	
	
	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", capital=" + capital + ", telephone="
				+ telephone + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
	
}
