package contact;

import contact.Contact;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
	// starts IDs at 1, but when a new contact is added, currentId will increase by 1. 
	private int currentId = 1;
	public List<Contact> contactList = new ArrayList<>();
	
	
	// Used for testing
	public void outputAllContacts() {
		for (int i = 0; i < contactList.size(); i++) {
			String contactId = contactList.get(i).getId();
		}
	}
	
	// Returns a contact based on the ID. 
	//If no contact is found with the passed ID, an empty instance of Contact is passed.
	public Contact searchContactById(String id) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId().equals(id)) {
				return contactList.get(i);
			}	
		}
		
		return new Contact();
	}
	
	// Adds contact with a unique ID to the list contactList, then increases currentId by 1. 
	public void addContact(String firstName, String lastName, String phone, String address) {
		Contact contact = new Contact(Integer.toString(currentId), firstName, lastName, phone, address);
		
		contactList.add(contact);
		currentId++;
	}
	
	
	// Uses searchContactById to find the contact to be deleted
	// If the Id is found, the contact is deleted
	// If the ID isn't found, an error is thrown
	public void deleteContact(String id) {
		
		Contact deleteContact = searchContactById(id);
			
		if (deleteContact.getId() != null) {
			for (int i = 0; i < contactList.size(); i++) {
				if (contactList.get(i).getId().equals(id)) {
					contactList.remove(i);
				}
			}
		} else {
			throw new IllegalArgumentException("Contact ID not found.");
		}
	}
	
	// Methods to modify specific Contact attributes (firstName, lastName, phone, & address) based on ID
	
	public void modifyFirstName(String id, String firstName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId().equals(id)) {
				contactList.get(i).setFirstName(firstName);
			}
		}
	}
	
	public void modifyLastName(String id, String lastName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId().equals(id)) {
				contactList.get(i).setLastName(lastName);
			}
		}
	}
	
	public void modifyPhone(String id, String phone) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId().equals(id)) {
				contactList.get(i).setPhone(phone);
			}
		}
	}
	
	public void modifyAddress(String id, String address) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getId().equals(id)) {
				contactList.get(i).setAddress(address);
			}
		}
	}
	
	
	
	
	
}