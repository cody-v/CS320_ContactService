/**
 * ContactService.java
 *
 * Author: Cody Vachon
 * Date: April 10, 2025
 *
 */

import java.util.HashMap;
import java.util.Map;

public class ContactService {

	// Map to store contacts using contact ID as the key
	final Map<String, Contact> contacts;

	// Constructor to initialize the contacts map
	public ContactService() {
		this.contacts = new HashMap<>();
	}

	// Adds a new contact to the service
	public void addContact(Contact contact) {
		// Check if the contact ID already exists
		if (contacts.containsKey(contact.getContactID())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		// Add the contact to the map
		contacts.put(contact.getContactID(), contact);
	}

	// Deletes a contact from the service using its ID
	public void deleteContact(String contactID) {
		// Check if the contact ID exists
		if (!contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}
		// Remove the contact from the map
		contacts.remove(contactID);
	}

	// Updates a contact's details based on its ID
	public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		// Check if the contact ID exists
		if (!contacts.containsKey(contactID)) {
			throw new IllegalArgumentException("Contact ID does not exist");
		}
		// Retrieve the existing contact
		Contact contact = contacts.get(contactID);
		// Update the first name if provided
		if (firstName != null) {
			contact.setFirstName(firstName);
		}
		// Update the last name if provided
		if (lastName != null) {
			contact.setLastName(lastName);
		}
		// Update the phone number if provided
		if (phone != null) {
			contact.setPhone(phone);
		}
		// Update the address if provided
		if (address != null) {
			contact.setAddress(address);
		}
	}
}


