/**
 * Contact.java
 *
 * Author: Cody Vachon
 * Date: April 10, 2025
 *
 */

public class Contact {

	// Unique contact ID (cannot be null or exceed 10 characters)
	private final String contactID;

	// First name of the contact (cannot be null or exceed 10 characters)
	private String firstName;

	// Last name of the contact (cannot be null or exceed 10 characters)
	private String lastName;

	// Phone number (must be 10 numeric digits)
	private String phone;

	// Address (cannot be null or exceed 30 characters)
	private String address;

	// Constructor: Validates and initializes all fields
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}

	// Returns the contact ID
	public String getContactID() {
		return contactID;
	}

	// Returns the first name
	public String getFirstName() {
		return firstName;
	}

	// Sets the first name (validates input)
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		this.firstName = firstName;
	}

	// Returns the last name
	public String getLastName() {
		return lastName;
	}

	// Sets the last name (validates input)
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		this.lastName = lastName;
	}

	// Returns the phone number
	public String getPhone() {
		return phone;
	}

	// Sets the phone number (validates input)
	public void setPhone(String phone) {
		if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		this.phone = phone;
	}

	// Returns the address
	public String getAddress() {
		return address;
	}

	// Sets the address (validates input)
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		this.address = address;
	}
}
