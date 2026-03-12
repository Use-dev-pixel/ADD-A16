package org.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.dto.Item;
import org.jsp.dto.Ordered;

public class OrderItemDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("onetomanybi");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveOrder(Ordered order) {
		entityTransaction.begin();
		entityManager.persist(order);
		entityTransaction.commit();
		System.out.println("Saved");

	}

	public void removeItemByItemId(int order_id, int item_id) {
		Ordered order = entityManager.find(Ordered.class, order_id);
		Item item = entityManager.find(Item.class, item_id);

		if (order != null) {
			// order.getItems().remove(item)
			List<Item> items = order.getItems();
			if (item != null && items.remove(item)) {
				entityTransaction.begin();
				entityManager.merge(order);
				entityManager.remove(item);
				entityTransaction.commit();
			} else {
				throw new RuntimeException("ItemNotFoundWithGivenIdException");
			}
		} else {
			throw new RuntimeException("OrderNotFoundWithGiveIdException");
		}
	}

}
