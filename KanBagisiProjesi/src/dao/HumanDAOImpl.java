package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Human;
import model.Login;
import utility.JPAUtility;

public class HumanDAOImpl implements HumanDAO {

	private EntityManager entityManager;

	public HumanDAOImpl() {
		EntityManagerFactory emf = JPAUtility.getEntityManagerFactory();
		if (entityManager == null) {
			entityManager = emf.createEntityManager();
		}

	}

	@Override
	public Human insertHuman(Human human) {
		entityManager.getTransaction().begin();
		entityManager.persist(human);
		entityManager.getTransaction().commit();

		return human;
	}

	@Override
	public Login loginRast(Login login) {
		entityManager.getTransaction().begin();
		entityManager.persist(login);
		entityManager.getTransaction().commit();

		return login;
	}

	@Override
	public void humanLogin(Human human, Login login) {
		entityManager.getTransaction().begin();
		human.setLogin(login);
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Human> humans() {
		TypedQuery<Human> query = entityManager.createQuery("Select hum from Human hum", Human.class);
		return query.getResultList();
	}

	@Override
	public List<Login> logins() {
		TypedQuery<Login> query = entityManager.createQuery("Select log from Login log", Login.class);
		return query.getResultList();
	}

	@Override
	public Login getLogin(String kullanýcýAdý, String password) {

		Query q = entityManager
				.createQuery("SELECT u FROM Login u WHERE u.kullanýcýAdý = :login AND u.password = :pass");
		q.setParameter("login", kullanýcýAdý);
		q.setParameter("pass", password);

		return (Login) q.getSingleResult();

	}

	public boolean inserirUser(Login login) {
		try {
			entityManager.persist(login);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletarUser(Login login) {
		try {
			entityManager.remove(login);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Human findHuman(int id) {

		return entityManager.find(Human.class, id);

	}

	@Override
	public Login findLogin(int id) {
		return entityManager.find(Login.class, id);
	}

	@Override
	public void removeHuman(int id) {
		Human human = findHuman(id);
		Login login = findLogin(id);
		entityManager.getTransaction().begin();
		entityManager.remove(human);
		entityManager.remove(login);
		entityManager.getTransaction().commit();

	}

	@Override
	public void updateHuman(int id,String newName) {
		Human update = findHuman(id);
		entityManager.getTransaction().begin();
		update.setName(update.getName() + newName);
		entityManager.getTransaction().commit();
	}

}
