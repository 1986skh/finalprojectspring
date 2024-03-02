package com.kat.gestibanque.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Actualite {

@Id @GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String titre;
private String description;
private LocalDate date = LocalDate.now();
private String image;

public Actualite() {

}
public Actualite(String image,String titre, String description, LocalDate date) {
	super();
	this.id = id;
	this.titre = titre;
	this.description = description;
	this.date = date;
	this.image=image;
}

@Override
public String toString() {
	return "Actualite [id=" + id + ", titre=" + titre + ", description=" + description + ", date="
			+ date +",image="+ image + "]";
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

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}






}
