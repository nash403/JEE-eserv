package fr.eservices.structure.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Structure {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String street;
	private String zipcode;
	private String region;
	private String city;
	private String country;
	@Enumerated(EnumType.STRING)
	private Status status;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString(){
		return "ID : " + id +" Name : " + name + " Street : " + street + " Zip Code : "+ zipcode + " Region : " + region + " Country : " + country + " Status : "+ status;
	}
<<<<<<< HEAD
	public static enum Status {
=======
	
	public enum Status {
>>>>>>> feat(formStructure): utilisation de jstl pour le formulaire de la creation de structure + creation de structure fonctionelle
		ENTREPRISE, ASSOCIATION
	}
}