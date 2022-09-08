package lab6;
/**
 * Title: Lab6App.java
 * Description:
 * 
 * @author KYUNGHOON OH
 *
 */

public class Lab6App {

	public static void main(String[] args)
	{
		PhoneBookEntry phoneBookEntry1 = new PhoneBookEntry();
		PhoneBookEntry phoneBookEntry2 = new PhoneBookEntry("Mary", "Smith", "631-123-4567", "03/15/1990", 'F');
		PhoneBookEntry phoneBookEntry3 = new PhoneBookEntry("Mary", "Smith", "516-572-7383", "04/10/1985", 'B');
		PhoneBookEntry phoneBookEntry4 = new PhoneBookEntry("John", "Smith", "516-572-7700", "01/20/1995", 'M');		
		System.out.println("Testing default constructor:" + "\n" + phoneBookEntry1.toString() + "\n");		
		System.out.println("Testing parameterized constructor:");
		
		System.out.println(phoneBookEntry2.toString() + "\n");
		System.out.println("Testing accessor methods:");
		System.out.println("First name: " + phoneBookEntry2.getFirstName());		
		System.out.println("Last name: " + phoneBookEntry2.getLastName());		
		System.out.println("Phone number: " + phoneBookEntry2.getPhoneNumber());
		System.out.println("Date of birth: " + phoneBookEntry2.getBirthDate());
		System.out.println("Relationship: " + phoneBookEntry2.getRelationship() + "\n");				
				
		phoneBookEntry1.setLastName("Doe");
		System.out.println("Testing mutator method for the last name on default object:" + 
		            "\n" + phoneBookEntry1.toString() + "\n");
		phoneBookEntry1.setPhoneNumber("516-123-4567");
		System.out.println("Testing mutator method for the phone number on default object:" +
		            "\n" + phoneBookEntry1.toString() + "\n");
		
		System.out.println("Testing equals method:");
		if (phoneBookEntry2.equals(phoneBookEntry3))
			System.out.println(phoneBookEntry2.toString() + "\n" + "IS THE SAME PERSON AS" + "\n" + 
		                phoneBookEntry3.toString() + "\n");
		else
			System.out.println(phoneBookEntry2.toString() + "\n" + "IS NOT THE SAME PERSON AS" + "\n" +
		                phoneBookEntry3.toString() + "\n");
		
			
		if (phoneBookEntry2.equals(phoneBookEntry4))
			System.out.println(phoneBookEntry2.toString() + "\n" + "IS THE SAME PERSON AS" + "\n" + 
		                phoneBookEntry4.toString());
		else
			System.out.println(phoneBookEntry2.toString() + "\n" + "IS NOT THE SAME PERSON AS" + "\n" +
		                phoneBookEntry4.toString() + "\n");
		
		
		
		
		System.out.println("Testing calculateAge method:" + "\n" + phoneBookEntry1.getFirstName() + " "
		            + phoneBookEntry1.getLastName() + " will be " + phoneBookEntry1.calculateAge()  + 
		            " years old in 2025.");
		System.out.println(phoneBookEntry2.getFirstName() + " " + phoneBookEntry2.getLastName() +
				" will be " + phoneBookEntry2.calculateAge()  + " years old in 2025.");		
		System.out.println(phoneBookEntry3.getFirstName() + " " + phoneBookEntry3.getLastName() +
				" will be " + phoneBookEntry3.calculateAge() + " years old in 2025.");
		System.out.println(phoneBookEntry4.getFirstName() + " " + phoneBookEntry4.getLastName() +
				" will be " + phoneBookEntry4.calculateAge()  + " years old in 2025.");
				
		
		
		
		
	}
}
