package main;


public class Contact {
	
	//attributes that each contact can have
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//default Constructor to set values for each contact when it is created
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		//validation for contactId values
		if (contactId == null || contactId.length() > 10 || contactId == "") {
			throw new IllegalArgumentException("The Contact ID cannot be null or greater than 10 characters.");
		}
		this.contactId = contactId;
		
		setFirstName(firstName);
		
		setLastName(lastName);
		
		setPhone(phone);
		
		setAddress(address);
	}
	
	//Getters to return values of contact object
	public String getContactId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	//setters to set values for contact object
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10 || firstName == "") {
			throw new IllegalArgumentException("first name cannot be null or greater than 10 characters.");
		}	
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10 || lastName == "") {
			throw new IllegalArgumentException("Last name cannot be null or greater than 10 characters.");
		}
		this.lastName = lastName;
	}
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10 || !phone.matches("[0-9]+")) {
			throw new IllegalArgumentException("Phone number cannot be null and needs to be 10 digits.");
		}
		this.phone = phone;
	}
	public void setAddress(String address) {
		if (address == null || address.length() > 30 || address == "") {
			throw new IllegalArgumentException("Address cannot be null or exceed 30 characters.");
		}
		this.address = address;
	}
}
