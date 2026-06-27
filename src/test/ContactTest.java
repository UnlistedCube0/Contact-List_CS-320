package test;

import contact.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;

public class ContactTest {
	
	@Test
	public void testContact( ) {
		Contact contact = new Contact("1", "Jimmy", "Johnson", "1234567890", "1234 Main Street");
		assertTrue(contact.getId().equals("1"));
		assertTrue(contact.getFirstName().equals("Jimmy"));
		assertTrue(contact.getLastName().equals("Johnson"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("1234 Main Street"));
	}
	
	@Test
	public void testFirstNameTooLong( ) {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1", "BrennanLeeMulligan", "Johnson", "1234567890", "1234 Main Street");
		});   
	}
	
	@Test
	public void testLastNameTooLong( ) {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1", "Jimmy", "JohnsonIsALongLastName", "1234567890", "1234 Main Street");
		});   
	}
	
	@Test
	public void testPhoneTooShort( ) {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1", "Jimmy", "Johnson", "1234567", "1234 Main Street");
		});   
	}
	
	@Test
	public void testPhoneTooLong( ) {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1", "Jimmy", "Johnson", "12345678910", "1234 Main Street");
		});   
	}
	
	@Test
	public void testAddressTooLong( ) {
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			new Contact("1", "Jimmy", "Johnson", "1234567890", "1234 Main Street Isnt a Pretty Common Address");
		});   
	}

}