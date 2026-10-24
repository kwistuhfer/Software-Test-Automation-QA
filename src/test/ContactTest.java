package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {
	
	//test to validate contact creation and all getters function properly
	@Test
	void createContactTest() {
		Contact AAA = new Contact("001", "John", "Doe", "7145551234", "1055 town road");
		assertEquals("001", AAA.getContactId());
		assertEquals("John", AAA.getFirstName());
		assertEquals("Doe", AAA.getLastName());
		assertEquals("7145551234", AAA.getPhone());
		assertEquals("1055 town road", AAA.getAddress());
	}
	//added validation for empty string
	@Test
	void emptyIdThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("", "Jane", "Doe", "7145555678", "1056 town road"));
	}
	
	@Test
	void emptyFirstNameThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("002", "", "Doe", "7145555678", "1056 town road"));
	}
	@Test
	void emptyLastNameThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("002", "Jane", "", "7145555678", "1056 town road"));
	}
	@Test
	void emptyPhoneThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("002", "Jane", "Doe", "", "1056 town road"));
	}
	@Test
	void emptyAddressThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("002", "Jane", "Doe", "7145555678", ""));
	}
	
	//added validation for boundary condition character limit
	@Test
	void boundaryContactTest() {
		Contact BBB = new Contact("0123456789", "John123456", "Doe1234567", "7145551234", "1055 town road ave. 1234567890");
		assertEquals("0123456789", BBB.getContactId());
		assertEquals("John123456", BBB.getFirstName());
		assertEquals("Doe1234567", BBB.getLastName());
		assertEquals("7145551234", BBB.getPhone());
		assertEquals("1055 town road ave. 1234567890", BBB.getAddress());
	}
	
	//test to validate Null throws exception
	
	@Test
	void NullIdThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact(null, "Jane", "Doe", "7145555678", "1056 town road"));
	}
	
	@Test
	void NullFirstNameThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("002", null, "Doe", "7145555678", "1056 town road"));
	}
	@Test
	void NullLastNameThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("002", "Jane", null, "7145555678", "1056 town road"));
	}
	@Test
	void NullPhoneThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("002", "Jane", "Doe", null, "1056 town road"));
	}
	@Test
	void NullAddressThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("002", "Jane", "Doe", "7145555678", null));
	}
	
	//test to validate input length
	@Test
	void longIdThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("0123456789a", "Jane", "Doe", "7145555678", "1056 town road"));
	}
	@Test
	void longFirstNameThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("0123456789", "JaneJaneJane", "Doe", "7145555678", "1056 town road"));
	}
	@Test
	void longLastNameThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("0123456789", "Jane", "DoeDoeDoeDoe", "7145555678", "1056 town road"));
	}
	@Test
	void longPhoneThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("0123456789", "Jane", "Doe", "71455556788", "1056 town road"));
	}
	@Test
	void shortPhoneThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("0123456789", "Jane", "Doe", "714555567", "1056 town road"));
	}
	@Test
	void longAddressThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("0123456789", "Jane", "Doe", "7145555678", "1056 town road 1056 town road way"));
	}
	//input validation to check if non digits throw exception for phone number
	@Test
	void alphaPhoneThrowsExceptionTest() {
		assertThrows(IllegalArgumentException.class, () -> 
		new Contact("0123456789", "Jane", "Doe", "714555567a", "1056 town road"));
	}
}
