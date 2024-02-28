package com.kat.gestibanque.entities;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Apropos {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String description;
//private byte[] image;
private String telephone;
private String adress;
private String email;


public Apropos() {

}
public Apropos(int id, String description,  String telephone, String adress, String email) {
	super();
	this.id = id;
	this.description = description;
	//this.image = image;
	this.telephone = telephone;
	this.adress = adress;
	this.email= email;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
/*public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}*/
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getEmailContact() {
	return email;
}
public void setEmailContact(String email) {
	this.email = email;
}





}
