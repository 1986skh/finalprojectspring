package com.kat.gestibanque.entities;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompteBancaire {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String numeroCompte;
	private LocalDate dateCreation=LocalDate.now();
	private Double montant;
	private String etatCompte;
	private TypeCompte typeCompte;
	public CompteBancaire() {
		super();
	}
	public CompteBancaire(int id, String numeroCompte, LocalDate dateCreation, Double montant, String etatCompte,
			TypeCompte typeCompte) {
		super();
		this.id = id;
		this.numeroCompte = numeroCompte;
		this.dateCreation = dateCreation;
		this.montant = montant;
		this.etatCompte = etatCompte;
		this.typeCompte = typeCompte;
	}
	@Override
	public String toString() {
		return "CompteBancaire [id=" + id + ", numeroCompte=" + numeroCompte + ", dateCreation=" + dateCreation
				+ ", montant=" + montant + ", etatCompte=" + etatCompte + ", typeCompte=" + typeCompte + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getEtatCompte() {
		return etatCompte;
	}
	public void setEtatCompte(String etatCompte) {
		this.etatCompte = etatCompte;
	}
	public TypeCompte getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

}
