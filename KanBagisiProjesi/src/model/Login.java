package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Login {

	@Id
	@TableGenerator(name = "Login_ID")
	@GeneratedValue(generator = "Login_ID")
	private int id;

	private String kullaniciAdi;
	private String password;

	public Login(String kullaniciAdi, String password) {
		this.kullaniciAdi = kullaniciAdi;
		this.password = password;
	}

	public Login() {
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

}
