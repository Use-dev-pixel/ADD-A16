package org.jsp.controller;

import java.util.ArrayList;
import java.util.List;

import org.jsp.dao.OrderItemDao;
import org.jsp.dto.Item;
import org.jsp.dto.Ordered;

public class OrderItemController {
	public static void main(String[] args) {
		OrderItemDao dao = new OrderItemDao();

		Item item1 = new Item();
		item1.setId(101);
		item1.setName("Idly");
		item1.setCategory("breakfast");
		item1.setCost(50);

		Item item2 = new Item();
		item2.setId(102);
		item2.setName("Dosa");
		item2.setCategory("breakfast");
		item2.setCost(80);

		Item item3 = new Item();
		item3.setId(103);
		item3.setName("Poori");
		item3.setCategory("breakfast");
		item3.setCost(60);

		Item item4 = new Item();
		item4.setId(104);
		item4.setName("Ice-Cream");
		item4.setCategory("Dessert");
		item4.setCost(40);

		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);

		Ordered ordered = new Ordered();
		ordered.setId(1);
		ordered.setCost(200);
		ordered.setNoOfItems(4);
		ordered.setItems(items);
		
//		dao.saveOrder(ordered);
		dao.removeItemByItemId(1,104);

	}
}
