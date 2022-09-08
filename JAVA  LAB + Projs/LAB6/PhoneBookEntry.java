package lab6;

/**
 * Title: PhoneBookEntry.java
 * Description:PhoneBookEntry calss will contain information for a single entry in a phone book.
 * 
 * @author KYUNGHOON OH
 *
 */
public class PhoneBookEntry {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String birthDate;
	private char relationship;
	
	public PhoneBookEntry()
	{
		this.firstName = ("None");
		this.lastName = ("None");
		this.phoneNumber = ("516-555-5555");
		this.birthDate = ("01/01/2013");
		this.relationship = ('X');		  
	}
	
	public String toString() {
		String str;
		if (this.relationship == 'F')
			 str = "Friend";
		else if (this.relationship == 'M')
			str = "Family Member";
		else if (this.relationship == 'B')
			str = "Business Associate";
		else
			str = "Not Specified";
		return this.lastName + ", " + this.firstName + "\n" + this.phoneNumber + "\n" + this.birthDate + "\n" + str;
	}
	public PhoneBookEntry(String firstname, String lastname, String phonenumber, String birthdate, char relationship)
	{
		this.firstName = firstname;
		this.lastName = lastname;
		this.phoneNumber = phonenumber;
		this.birthDate = birthdate;
		this.relationship = relationship;		
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	
	public String getLastName()
	{
		return this.lastName;
	}
	
	public String getPhoneNumber()
	{
		return this.phoneNumber;
	}
	public String getBirthDate()
	{
		return this.birthDate;
	}
	public char getRelationship()
	{
		return this.relationship;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public boolean equals(PhoneBookEntry otherPhoneBookEntry)
	{
		if (this.firstName.equals(otherPhoneBookEntry.firstName) &&
				(this.lastName.equals(otherPhoneBookEntry.lastName)))
			return true;
		else
			return false;
	}
	
	
	
	public int calculateAge()
	{
		int d = Integer.parseInt(birthDate.substring(6, 10));
		return 2025 - d;		
	}

}
