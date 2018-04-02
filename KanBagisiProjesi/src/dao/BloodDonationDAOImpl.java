package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.BloodDonation;
import utility.JPAUtility;

public class BloodDonationDAOImpl implements BloodDonationDAO{
	
	private EntityManager entityManager;

	public BloodDonationDAOImpl() {
		EntityManagerFactory emf = JPAUtility.getEntityManagerFactory();
		if (entityManager == null) {
			entityManager = emf.createEntityManager();
		}

	}

	@Override
	public BloodDonation insertbloodDonation(BloodDonation bloodDonation) {
		entityManager.getTransaction().begin();
		entityManager.persist(bloodDonation);
		entityManager.getTransaction().commit();

		return bloodDonation;
	} 

}
