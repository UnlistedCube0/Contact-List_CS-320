package test;

import contact.ContactService;
import contact.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;

public class ContactServiceTest {
	ContactService contactService = new ContactService();
		
	
	@Test
	public void testAddContact( ) {
		contactService.addContact("FirstName", "LastName", "1234567890", "1234 Main Street");
		assertTrue(contactService.contactList.get(0).getId().equals("1"));
		assertTrue(contactService.contactList.get(0).getFirstName().equals("FirstName"));
		assertTrue(contactService.contactList.get(0).getLastName().equals("LastName"));
		assertTrue(contactService.contactList.get(0).getPhone().equals("1234567890"));
		assertTrue(contactService.contactList.get(0).getAddress().equals("1234 Main Street"));
	}
	
	
	@Test
	public void testAddMultipleContacts( ) {
		contactService.addContact("Jimmy", "Johnson", "1234567890", "1234 Main Street");
		contactService.addContact("James", "Johnson", "1234567890", "1234 Main Street");
		assertTrue(contactService.contactList.get(0).getId().equals("1"));
		assertTrue(contactService.contactList.get(0).getFirstName().equals("Jimmy"));
		assertTrue(contactService.contactList.get(1).getId().equals("2"));
		assertTrue(contactService.contactList.get(1).getFirstName().equals("James"));
	}
	
	
	@Test
	public void testDeleteContact( ) {
		// Adds 2 contacts, and checks that the first one exists.
		// Then deletes the first contact, and rechecks that it's there.
		// Deleting contact with ID "1" should work the first time, but not the second time.
		contactService.addContact("Jimmy", "Johnson", "1234567890", "1234 Main Street");
		contactService.addContact("James", "Johnson", "1234567890", "1234 Main Street");
		assertTrue(contactService.contactList.get(0).getId().equals("1"));
			
		contactService.deleteContact("1");
		
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.deleteContact("1");
		});
				
	}
	
	
	@Test 
	void testModifyContactFirstName() {
		contactService.addContact("FirstName", "LastName", "1234567890", "123 1st Street");
		assertTrue(contactService.contactList.get(0).getFirstName().equals("FirstName"));
		
		// Test for a passed new name that's valid
		contactService.modifyFirstName("1", "FirstName2");
		assertTrue(contactService.contactList.get(0).getFirstName().equals("FirstName2"));
		
		// Test for if the passed new name is too long 
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.modifyFirstName("1", "FirstNameThatIsTooLong");
		});   
	}
	
	@Test 
	void testModifyContactLastName() {
		contactService.addContact("FirstName", "LastName", "1234567890", "123 1st Street");
		assertTrue(contactService.contactList.get(0).getLastName().equals("LastName"));
		
		// Test for a passed new name that's valid
		contactService.modifyLastName("1", "LastName2");
		assertTrue(contactService.contactList.get(0).getLastName().equals("LastName2"));
		
		// Test for if the passed new name is too long 
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.modifyLastName("1", "LastNameThatIsTooLong");
		});   
	}
	
	@Test 
	void testModifyContactPhone() {
		contactService.addContact("FirstName", "LastName", "1234567890", "123 1st Street");
		assertTrue(contactService.contactList.get(0).getPhone().equals("1234567890"));
		
		// Test for a passed new phone that's valid
		contactService.modifyPhone("1", "0987654321");
		assertTrue(contactService.contactList.get(0).getPhone().equals("0987654321"));
		
		// Test for a passed new phone that's too long
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.modifyPhone("1", "1234567890987654321");
		});   
		
		// Test for a passed new phone that's too short
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.modifyPhone("1", "12345");
		});  
	}
	
	
	@Test 
	void testModifyContactAddress() {
		contactService.addContact("FirstName", "LastName", "1234567890", "123 1st Street");
		assertTrue(contactService.contactList.get(0).getAddress().equals("123 1st Street"));
		
		// Test for a passed new address that's valid
		contactService.modifyAddress("1", "123 Main St");
		assertTrue(contactService.contactList.get(0).getAddress().equals("123 Main St"));
		
		// Test for a passed new address that's too long
		Assertions.assertThrows(IllegalArgumentException.class, ()-> {
			contactService.modifyAddress("1", "1234 Main St is fake address for testing.");
		});    
	}
	
		
}