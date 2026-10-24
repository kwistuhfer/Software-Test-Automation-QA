package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Contact;
import main.ContactService;

//import beforeEach to avoid repetition in tests 
import org.junit.jupiter.api.BeforeEach;


class ContactServiceTest {

	private ContactService service;
	
	//using beforeEach to set up a contactService once for readability and isolation 
	@BeforeEach
	void setUp() {
		service = new ContactService();
	}
	
	@Test
	void addContactTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		assertEquals(AAA, service.getContact("001"));
	}
	
	@Test
	void addNullContactTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		service.addContact(null));
	}
	
	@Test
	void deleteNullContactTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		service.deleteContact(null));
	}
	
	//test adding duplicate contact triggers throw exception
	@Test
	void addDuplicateThrowsTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		Contact BBB = new Contact("001", "Jane", "Roe", "1234567899", "1055 main rd");
		assertThrows(IllegalArgumentException.class, () -> service.addContact(BBB));
	}
	
	//test to verify contact gets deleted
	@Test
	void deleteContactTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		service.deleteContact("001");
		assertThrows(IllegalArgumentException.class, () -> service.getContact("001"));
	}
	
	//test to verify throw exception when deleting a non existent contact
	@Test
	void deleteNonExistentContactTest() {
		assertThrows(IllegalArgumentException.class, () -> service.deleteContact("001"));
	}
	
	//test to verify values update successfully 
	@Test
	void updateFirstNameTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		service.updateFirstName("001", "Jane");
		
		assertEquals("Jane", AAA.getFirstName());
	}
	
	@Test
	void updateLastNameTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		service.updateLastName("001", "Boe");
		
		assertEquals("Boe", AAA.getLastName());
	}
	
	@Test
	void updatePhoneTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		service.updatePhone("001", "0987654321");
		
		assertEquals("0987654321", AAA.getPhone());
	}
	
	@Test
	void updateAddressTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		service.updateAddress("001", "5510 main st");
		
		assertEquals("5510 main st", AAA.getAddress());
	}
	
	//added test to verify null values throw
	
	@Test
	void updateNullFirstNameTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateFirstName("001", null));
	}
	
	@Test
	void updateNullLastNameTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateLastName("001", null));
	}
	
	@Test
	void updateNullPhoneTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		
		assertThrows(IllegalArgumentException.class, () -> 
		service.updatePhone("001", null));
	}
	
	@Test
	void updateNullAddressTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateAddress("001", null));
	}
	
	//added test to verify empty values throw
	
	@Test
	void updateEmptyFirstNameTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
			
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateFirstName("001", ""));
	}
		
	@Test
	void updateEmptyLastNameTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
			
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateLastName("001", ""));
	}
		
	@Test
	void updateEmptyPhoneTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
			
		assertThrows(IllegalArgumentException.class, () -> 
		service.updatePhone("001", ""));
	}
		
	@Test
	void updateEmptyAddressTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
			
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateAddress("001", ""));
	}
	
	//added test to verify long values throw
	
	@Test
	void updateLongFirstNameTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
				
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateFirstName("001", "This is too long"));
	}
			
	@Test
	void updateLongLastNameTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
				
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateLastName("001", "This is too long"));
	}
			
	@Test
	void updateLongAddressTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
				
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateAddress("001", "This is too long because it should not exceed 30 characters in length"));
	}
	
	//verify updating values with nonexistent ID's throws
	
	@Test
	void updateNonIdFirstNameTest() {
				
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateFirstName("001", "Chris"));
	}
			
	@Test
	void updateNonIdLastNameTest() {
		
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateLastName("001", "Olvera"));
	}
	
	@Test
	void updateNonIdPhoneTest() {
			
		assertThrows(IllegalArgumentException.class, () -> 
		service.updatePhone("001", "1234567890"));
	}
			
	@Test
	void updateNonIdAddressTest() {
				
		assertThrows(IllegalArgumentException.class, () -> 
		service.updateAddress("001", "1055 main st"));
	}
	
	//verify boundary conditions pass when updating values
	@Test
	void updateBoundaryFirstNameTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		service.updateFirstName("001", "Jane123456");
		
		assertEquals("Jane123456", AAA.getFirstName());
	}
	
	@Test
	void updateBoundaryLastNameTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		service.updateLastName("001", "Doe1234567");
		
		assertEquals("Doe1234567", AAA.getLastName());
	}
	
	@Test
	void updateBoundaryAddressTest() {
		Contact AAA = new Contact("001", "John", "Doe", "1234567890", "1055 main st");
		service.addContact(AAA);
		service.updateAddress("001", "5510 main street12345678901234");
		
		assertEquals("5510 main street12345678901234", AAA.getAddress());
	}
	
}	
