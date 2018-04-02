package model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;

import controller.Listener;

@EntityListeners(Listener.class)
@Entity
public class Human {

	@Id
	@TableGenerator(name = "HUMAN_ID")
	@GeneratedValue(generator = "HUMAN_ID")
	private int id;

	private String name;
	private String surname;
	private String eposta;
	private String kanGrubu;
	private String telefon;
	private String adres;
	private boolean guncellemeDurumu;

	public boolean isGuncellemeDurumu() {
		return guncellemeDurumu;
	}

	public void setGuncellemeDurumu(boolean guncellemeDurumu) {
		this.guncellemeDurumu = guncellemeDurumu;
	}

	@OneToOne
	private Login login;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Human() {

	}

	public Human(String name, String surname, String eposta, String kanGrubu, String telefon, String adres) {
		this.name = name;
		this.surname = surname;
		this.eposta = eposta;
		this.kanGrubu = kanGrubu;
		this.telefon = telefon;
		this.adres = adres;

	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
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

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public String getKanGrubu() {
		return kanGrubu;
	}

	public void setKanGrubu(String kanGrubu) {
		this.kanGrubu = kanGrubu;
	}

	@Override
	public String toString() {
		return "Human [id=" + id + ", name=" + name + ", surname=" + surname + ", eposta=" + eposta + ", kanGrubu="
				+ kanGrubu + ", telefon=" + telefon + ", adres=" + adres + "]";
	}

}
