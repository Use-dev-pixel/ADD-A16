package org.jsp.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdharCard {
	@Id
	private long adhar_id;
	private String dateOfBirth;
	private String gender;

	public long getAdhar_id() {
		return adhar_id;
	}

	public void setAdhar_id(long adhar_id) {
		this.adhar_id = adhar_id;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
