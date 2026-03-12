package org.jsp.controller;

import org.jsp.dao.PersonAdharDao;
import org.jsp.dto.AdharCard;
import org.jsp.dto.Person;

public class PersonAdharController {
	public static void main(String[] args) {
		Person person = new Person();
		person.setId(104);
		person.setName("Hanuman");
		person.setEmail("Hanuman@gmail.com");
		person.setPassword("Hanuman@12345");
		person.setAddress("Pune");

		AdharCard card = new AdharCard();
		card.setAdhar_id(123478531234L);
		card.setDateOfBirth("Imortal");
		card.setGender("Male");
		
		
		PersonAdharDao dao=new PersonAdharDao();
//		Case 1 : person has adhar card and adhar card has person
//		person.setAdharCard(card);
//		card.setPerson(person);
//		dao.savePerson(person);
		
//		Case 2 : AdharCard has Person and person has AdharCard
//		card.setPerson(person);
//		person.setAdharCard(card);
//		dao.saveAdharCard(card);
		
//		Case 3 : Person has adharCard and adharCard Does not have Person
//		person.setAdharCard(card);
//		dao.savePerson(person);

//		Case 4 : AdharCard Has Person but person Doesn't Have AdharCard
//		card.setPerson(person);
//		dao.saveAdharCard(card);
		
		
		//ExtraMethods Execution
//		dao.addAdharCardToPerson(104, card);	
		dao.removeAdharCardFromPerson(456734567890L);
		
	}
}
