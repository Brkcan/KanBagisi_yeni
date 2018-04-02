package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class BloodDonation {

	@Id
	@TableGenerator(name = "Blood_ID")
	@GeneratedValue(generator = "Blood_ID")
	private int id;
	
	private String name;
	private String surname;
	private String kanGrubu;

	public BloodDonation() {
	}

	public BloodDonation(String name, String surname, String kanGrubu) {
		this.name = name;
		this.surname = surname;
		this.kanGrubu = kanGrubu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getKanGrubu() {
		return kanGrubu;
	}

	public void setKanGrubu(String kanGrubu) {
		this.kanGrubu = kanGrubu;
	}

}
