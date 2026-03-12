package org.jsp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ordered {
	@Id
	private int id;
	private int noOfItems;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> items;
	private double cost;

	@Override
	public String toString() {
		return "Ordered [id=" + id + ", noOfItems=" + noOfItems + ", items=" + items + ", cost=" + cost + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
