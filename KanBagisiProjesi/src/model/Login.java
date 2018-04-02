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

	private String kullan�c�Ad�;
	private String password;

	public Login(String kullan�c�Ad�, String password) {
		this.kullan�c�Ad� = kullan�c�Ad�;
		this.password = password;
	}

	public Login() {
	}

	public String getKullan�c�Ad�() {
		return kullan�c�Ad�;
	}

	public void setKullan�c�Ad�(String kullan�c�Ad�) {
		this.kullan�c�Ad� = kullan�c�Ad�;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
