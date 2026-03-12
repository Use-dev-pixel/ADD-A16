package org.jsp.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {
	@Id
	private int id;
	private String name;
	private double cost;
	private String category;

	@ManyToOne(cascade = CascadeType.ALL)
	private Ordered order;

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", cost=" + cost + ", category=" + category + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Ordered getOrder() {
		return order;
	}

	public void setOrder(Ordered order) {
		this.order = order;
	}

}
