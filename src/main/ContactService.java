package main;

import java.util.Map;
import java.util.HashMap;

public class ContactService {
	
	//initialize the map of contacts
	private Map<String, Contact> contacts = new HashMap<>();
	
	
	public void addContact(Contact contact) {
		//ensures null values for method throws exception
		if (contact == null) {
			throw new IllegalArgumentException("Contact cannot be null.");
		}
		//check is contactID already exists before adding new contact
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Invalid ID");
		}
		//if ID does not exist, add to contacts 
		contacts.put(contact.getContactId(), contact);
	}
	
	public void deleteContact(String contactId) {
		//throw exception for null entries & entries that dont exist
		if (contactId == null) {
			throw new IllegalArgumentException("Contact cannot be null");
		}
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("ID does not exist");
		}
		//if entry exists, remove from map
		contacts.remove(contactId);
	}
	
	/* old method to update contact info using contact ID
	 
	public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
		if (contactId == null) {
			throw new IllegalArgumentException("Contact ID cannot be null.");
		}
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("ID does not exist.");
		}
		Contact contact = contacts.get(contactId);
		if (firstName != null) {contact.setFirstName(firstName);}
		if (lastName != null) {contact.setLastName(lastName);}
		if (phone != null) {contact.setPhone(phone);}
		if (address != null) {contact.setAddress(address);}
	}
	
	*/
	
	//added updated methods to update contact info
	public void updateFirstName(String contactId, String firstName) {
		if (contactId == null || contactId.length() > 10 || contactId == "") {
			throw new IllegalArgumentException("The Contact ID cannot be null or greater than 10 characters.");
		}
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("ID does not exist.");
		}
		Contact contact = contacts.get(contactId);
		contact.setFirstName(firstName);
		
	}

	public void updateLastName(String contactId, String lastName) {
		if (contactId == null || contactId.length() > 10 || contactId == "") {
			throw new IllegalArgumentException("The Contact ID cannot be null or greater than 10 characters.");
		}
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("ID does not exist.");
		}
		Contact contact = contacts.get(contactId);
		contact.setLastName(lastName);
	}
	
	public void updatePhone(String contactId, String phone) {
		if (contactId == null || contactId.length() > 10 || contactId == "") {
			throw new IllegalArgumentException("The Contact ID cannot be null or greater than 10 characters.");
		}
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("ID does not exist.");
		}
		Contact contact = contacts.get(contactId);
		contact.setPhone(phone);
	}
	
	public void updateAddress(String contactId, String address) {
		if (contactId == null || contactId.length() > 10 || contactId == "") {
			throw new IllegalArgumentException("The Contact ID cannot be null or greater than 10 characters.");
		}
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("ID does not exist.");
		}
		Contact contact = contacts.get(contactId);
		contact.setAddress(address);
	}
	
	
	//simple method to return a contact ID. used to test "addcontact" method in test class
	public Contact getContact(String contactId) {
		if (contactId == null) {
	        throw new IllegalArgumentException("Contact ID cannot be null");
	    }
	    if (!contacts.containsKey(contactId)) {
	        throw new IllegalArgumentException("ID does not exist");
	    }
	    return contacts.get(contactId);
	}
	
}
