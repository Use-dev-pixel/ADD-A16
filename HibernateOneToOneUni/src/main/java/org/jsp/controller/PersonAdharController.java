package org.jsp.controller;

import org.jsp.dao.PersonAdharDao;
import org.jsp.dto.AdharCard;
import org.jsp.dto.Person;

public class PersonAdharController {
	public static void main(String[] args) {
		Person person = new Person();
		person.setId(101);
		person.setName("ram");
		person.setEmail("ram@gmail.com");
		person.setPassword("ram@12345");
		person.setAddress("Pune");

		AdharCard card = new AdharCard();
		card.setAdhar_id(789076544563L);
		card.setDateOfBirth("26/08/1912");
		card.setGender("Male");
		
		
		person.setAdharCard(card);
		
		
		PersonAdharDao dao=new PersonAdharDao();
		
		dao.savePerson(person);

	}
}
