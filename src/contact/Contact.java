package contact;

public class Contact {
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		
		// id cannot be null or longer than 10 characters or updatable
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		// firstName cannot be null or longer than 10 character
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		// lastName cannot be null or longer than 10 character
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		// phone must be exactly 10 digits and cannot be null
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone");
		}
		
		// address cannot be null or longer than 30 characters
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;		
	}
	
	// Instance of Contact for when no variables are passed.
	// Allows to searchContactById function in ContactService.java
	public Contact() {
		
	}
	
	
	// Getters
	
	public String getId() {
		return id;
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
	
	
	// Setters
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone");
		}
		
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		this.address = address;
	}
	
	
}