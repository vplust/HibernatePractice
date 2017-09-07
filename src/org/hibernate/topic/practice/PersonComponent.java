package org.hibernate.topic.practice;

import java.io.*;
import java.text.*;
import java.util.*;

public class PersonComponent {
	private static PersonService ps= new PersonService();
	public static void main(String[] args) throws Exception {
	//Converting file to byte[] to save in DB as Lob
		File image = new File("c:\\users\\vikas\\desktop\\image.jpg");
		byte b[] = new byte[(int)image.length()];
		FileInputStream fis = new FileInputStream(image);
		fis.read(b);
		
	//Creating SQL date, @Temporal is used on util.Date so using sqlDate not necessary
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());  //Sqldate
		java.sql.Timestamp ts = new java.sql.Timestamp(date.getTime());     //timestamp

	//Multiple Embeddable objects of same class 
		AddressEmbeddableInPerson addressHome = new AddressEmbeddableInPerson();
		addressHome.setFlat_Street_Neighbourhood("Gali no 2, House no 7, Sector 45");
		addressHome.setCity("Noida");
		addressHome.setState("U.P");
		addressHome.setCountry("India");
		addressHome.setPincode(201301);
		
		AddressEmbeddableInPerson addressOffice = new  AddressEmbeddableInPerson();
		addressOffice.setFlat_Street_Neighbourhood("E-150");
		addressOffice.setCity("Noida");
		addressOffice.setPincode(201301);
		addressOffice.setState("UP");
		addressOffice.setCountry("India");
	
	//Save  Collection Object
		String[] places={"Noida","Delhi","Kanpur"};
		List<String> placesVisited = Arrays.asList(places);
		

		Person person = new Person();
		person.setName("Vikas");
		person.setPicture(b);
		person.setAttendanceTime(ts);
		person.setDob(date);
		person.setAddressHome(addressHome);
		person.setAddressOffice(addressOffice);
		person.setPlacesVisited(placesVisited);



		ps.save(person);
		//ps.get(1);
	}

}
