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

	private String kullanıcıAdı;
	private String password;

	public Login(String kullanıcıAdı, String password) {
		this.kullanıcıAdı = kullanıcıAdı;
		this.password = password;
	}

	public Login() {
	}

	public String getKullanıcıAdı() {
		return kullanıcıAdı;
	}

	public void setKullanıcıAdı(String kullanıcıAdı) {
		this.kullanıcıAdı = kullanıcıAdı;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
