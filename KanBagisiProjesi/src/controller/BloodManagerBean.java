package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.BloodDonationDAO;
import dao.BloodDonationDAOImpl;
import model.BloodDonation;

@ManagedBean
@SessionScoped
public class BloodManagerBean {

	private String name;
	private String surname;
	private String kanGrubu;

	public BloodManagerBean() {
	}

	public BloodManagerBean(String name, String surname, String kanGrubu) {
		this.name = name;
		this.surname = surname;
		this.kanGrubu = kanGrubu;
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

	public String addBloodDonation() {
		BloodDonationDAO bloodDonationDAO = new BloodDonationDAOImpl();
		BloodDonation bloodDonation = new BloodDonation(name, surname, kanGrubu);
		bloodDonationDAO.insertbloodDonation(bloodDonation);

		if(name != null && surname != null) {
			return "success";
		}
		return "null";
	}
}
