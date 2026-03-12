package org.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.dto.AdharCard;
import org.jsp.dto.Person;

public class PersonAdharDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("onetoone_bi");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public void savePerson(Person person) {
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
		System.out.println("Saved");
	}

	public void saveAdharCard(AdharCard card) {
		entityTransaction.begin();
		entityManager.persist(card);
		entityTransaction.commit();
	}
	
	public void addAdharCardToPerson(int id,AdharCard card) {
		Person person=entityManager.find(Person.class, id);
		
		if (person!=null) {
//			person.setAdharCard(card);
//			card.setPerson(person);
			entityTransaction.begin();
//			entityManager.merge(person);
			entityManager.remove(card);
			entityTransaction.commit();
		} else {
			throw new RuntimeException("PersonNotFoundException");
		}
		
		
	}
	
	public void removeAdharCardFromPerson(long aid) {

		AdharCard card=entityManager.find(AdharCard.class, aid);
		
		if (card!=null) {
			Person person=card.getPerson();
			card.setPerson(null);
			person.setAdharCard(null);
	
			entityTransaction.begin();
			entityManager.remove(card);
			entityTransaction.commit();
		} else {
			throw new RuntimeException("AdharCardNotFoundException");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
