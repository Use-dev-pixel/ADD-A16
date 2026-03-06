package org.jsp.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.dto.Student;

public class StudentController {
	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("first");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Student student = new Student();
		student.setId(32);
		student.setName("reeya");
		student.setEmail("reeya@gmail.com ");
		student.setPassword("reeya@12345");
		student.setNumber(3254775477l);
		student.setAddress("JNTU");
		
		
		transaction.begin();
		manager.persist(student);
		transaction.commit();
	}
}
