package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import dao.HumanDAO;
import dao.HumanDAOImpl;
import model.Human;
import model.Login;

@ManagedBean
@SessionScoped
public class HumanManagedBean {

	private String name;
	private String surname;
	private String eposta;
	private String kanGrubu;
	private String telefon;
	private String adres;
	private String kullaniciAdi;
	private String password;
	private Login login;
	private List<Human> humanss;
	private Human humans;
	public Human getHumans() {
		return humans;
	}

	public void setHumans(Human humans) {
		this.humans = humans;
	}

	private List<Login> logins;
	private List<Human> kaydet = new ArrayList<>();
	
	public void listHuman() {
		HumanDAO human = new HumanDAOImpl();
		humanss = human.humans();
		
		for(Human hu : humanss) {
			System.out.println(hu);
		}
	}
	
	public String degisikligiKaydet() {
		for(Human human : kaydet) {
			human.setGuncellemeDurumu(false);
		}
		return null;
	}

	public List<Human> getKaydet() {
		return kaydet;
	}

	public void setKaydet(List<Human> kaydet) {
		this.kaydet = kaydet;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public List<Human> getHumanss() {
		return humanss;
	}

	public void setHumanss(List<Human> humanss) {
		this.humanss = humanss;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public HumanManagedBean(String name, String surname, String eposta, String kanGrubu, String telefon, String adres) {
		this.name = name;
		this.surname = surname;
		this.eposta = eposta;
		this.kanGrubu = kanGrubu;
		this.telefon = telefon;
		this.adres = adres;
	}

	public HumanManagedBean() {

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



	public String getAddHuman() {
		HumanDAO humanDAO = new HumanDAOImpl();

		Random r = new Random();
		String kod = "";
		String password = "";
		int karakterSayisi = 5;
		String alphabet = "1234567890abcdefghijklmnoprstuvyzx";
		for (int i = 0; i < karakterSayisi; i++) {
			kod += alphabet.charAt(r.nextInt(alphabet.length()));
			password += alphabet.charAt(r.nextInt(alphabet.length()));
		}

		Login login = new Login(kod, password);

		Human human = new Human(name, surname, eposta, kanGrubu, telefon, adres);

		humanDAO.insertHuman(human);
		humanDAO.loginRast(login);
		humanDAO.humanLogin(human, login);
		humanss = humanDAO.humans();
		logins = humanDAO.logins();

		//
		if (name != null && surname != null && kanGrubu != null) {
			return "success";
		}
		return "Kullanici Adi = " + kod + " " + "Sifreniz  : " + password;

	}

	public String login() {
		String flag = "failure";
		HumanDAO humanDAO = new HumanDAOImpl();
		Login user = new Login();
		try {
			user = humanDAO.getLogin(kullaniciAdi, password);
			if (kullaniciAdi.equalsIgnoreCase(user.getKullaniciAdi()) && password.equals(user.getPassword())) {
				return "success";
			}
		} catch (Exception e) {
			return null;
		}
		return flag;

	}

	public void deleteHuman(int id) {
		HumanDAO humanDAO = new HumanDAOImpl();
		humanDAO.removeHuman(id);
		humanss = humanDAO.humans();
		logins = humanDAO.logins();
	}
	public String guncellemeDurumu(Human human) {
		human.setGuncellemeDurumu(true);
		return null;
	}

	public void updateHuman(int id) {
		HumanDAO humanDAO = new HumanDAOImpl();
		//Human human = new Human(name, surname, eposta, kanGrubu, telefon, adres);
		humanDAO.updateHuman(id, name);
		//humanDAO.insertHuman(human);
		humanss = humanDAO.humans();
		logins = humanDAO.logins();
	}
	 public Human onRowSelect(SelectEvent event) {
     FacesMessage msg = new FacesMessage("Car Selected", (((Human) event.getObject()).getName()));
     FacesContext.getCurrentInstance().addMessage(null, msg);
	return humans;
 }

 public Human onRowUnselect(UnselectEvent event) {
     FacesMessage msg = new FacesMessage("Car Unselected", ((Human) event.getObject()).getName());
     FacesContext.getCurrentInstance().addMessage(null, msg);
	return humans;
 }
}
