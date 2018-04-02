package dao;

import java.util.List;

import model.Human;
import model.Login;

public interface HumanDAO {

	public Human insertHuman(Human human);
	
	public Login loginRast(Login login);
	
	public void humanLogin(Human human, Login login);
	
	public List<Human> humans();
	
	public List<Login> logins();
	
	public Login getLogin(String kullanýcýAdý, String password);
	
	public void removeHuman(int id);
	
	public Human findHuman(int id);
	
	public Login findLogin(int id);
	
	public void updateHuman(int id, String newName);
}
