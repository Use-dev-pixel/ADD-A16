package org.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.dto.Employee;

public class EmployeeDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("second");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}

	public void findEmployeeByEmail(String email) {
//		Employee employee = entityManager.find(Employee.class, email); this doesn't work

		// import it form javax.persistence package

		// Position based
//		Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.email=?1");
//		query.setParameter(1, email);

		// named
		Query query = entityManager.createQuery("SELECT z FROM Employee z WHERE z.email=:email");
		query.setParameter("email", email);

		try {
			Employee employee = (Employee) query.getSingleResult();
			System.out.println(employee);
		} catch (NoResultException e) {
			throw new RuntimeException("Employee Not Found Exception");
		}
	}

	public void updateNameByEmail(String email, String name) {
		entityTransaction.begin();
		Query query = entityManager.createQuery("UPDATE Employee SET ename=?1 WHERE email=?2");
		query.setParameter(1, name);
		query.setParameter(2, email);
		int result = query.executeUpdate();
		entityTransaction.commit();
		if (result == 1) {
			System.out.println("Updated");
		} else {
			throw new RuntimeException("No Employee Found with given Email");
		}
	}

	public void findAllEmployees() {
		Query query = entityManager.createQuery("SELECT e FROM Employee e");
		List<Employee> employees = query.getResultList();
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
}
