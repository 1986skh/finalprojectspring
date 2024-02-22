package com.kat.gestibanque.entities;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;

@Entity
public class Actualite {
private int id;
private String titre;
private String description;
private LocalDate date;

public Actualite() {

}
public Actualite(int idActualite, String titre, String description, LocalDate date) {
	super();
	this.id = idActualite;
	this.titre = titre;
	this.description = description;
	this.date = date;
}

@Override
public String toString() {
	return "Actualite [idActualite=" + id + ", titre=" + titre + ", description=" + description + ", date="
			+ date + "]";
}

public int getIdActualite() {
	return id;
}

public void setIdActualite(int idActualite) {
	this.id = idActualite;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public LocalDate getDate() {
	return date;
}

public void setDate(LocalDate date) {
	this.date = date;
}






}
