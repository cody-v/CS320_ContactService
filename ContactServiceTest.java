/**
 * ContactServiceTest.java
 *
 * Author: Cody Vachon
 * Date: April 10, 20225
 *
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

	@Test
	void addContact_ValidContact_AddsContact() {
		// Test: Adding a valid contact should add it to the contacts map
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
		// Verify the contact is added to the map with the correct ID
		assertEquals(contact, service.contacts.get("12345"));
	}

	@Test
	void addContact_DuplicateId_ThrowsException() {
		// Test: Adding a contact with an existing ID should throw an exception
		ContactService service = new ContactService();
		Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		Contact contact2 = new Contact("12345", "Jane", "Smith", "9876543210", "456 Elm St");
		service.addContact(contact1);
		// Verify that adding another contact with the same ID throws an exception
		assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
	}

	@Test
	void deleteContact_ValidId_DeletesContact() {
		// Test: Deleting a contact with a valid ID should remove it from the contacts map
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
		service.deleteContact("12345");
		// Verify the contact is removed
		assertNull(service.contacts.get("12345"));
	}

	@Test
	void deleteContact_InvalidId_ThrowsException() {
		// Test: Deleting a contact with an invalid ID should throw an exception
		ContactService service = new ContactService();
		// Verify that an exception is thrown for a non-existent ID
		assertThrows(IllegalArgumentException.class, () -> service.deleteContact("invalidId"));
	}

	@Test
	void updateContact_ValidId_UpdatesContact() {
		// Test: Updating a contact with valid details should update the correct fields
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
		service.updateContact("12345", "Jane", "Smith", "9876543210", "456 Elm St");
		// Verify the contact fields are updated correctly
		Contact updatedContact = service.contacts.get("12345");
		assertEquals("Jane", updatedContact.getFirstName());
		assertEquals("Smith", updatedContact.getLastName());
		assertEquals("9876543210", updatedContact.getPhone());
		assertEquals("456 Elm St", updatedContact.getAddress());
	}

	@Test
	void updateContact_InvalidId_ThrowsException() {
		// Test: Updating a contact with an invalid ID should throw an exception
		ContactService service = new ContactService();
		// Verify that an exception is thrown when trying to update a non-existent ID
		assertThrows(IllegalArgumentException.class, () -> service.updateContact("invalidId", "Jane", "Smith", "9876543210", "456 Elm St"));
	}

	@Test
	void updateContact_NullFirstName_DoesNotUpdateFirstName() {
		// Test: Updating a contact with a null first name should not change the first name
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
		service.updateContact("12345", null, "Smith", "9876543210", "456 Elm St");
		// Verify the first name remains unchanged
		assertEquals("John", service.contacts.get("12345").getFirstName());
	}

	@Test
	void updateContact_NullLastName_DoesNotUpdateLastName() {
		// Test: Updating a contact with a null last name should not change the last name
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
		service.updateContact("12345", "Jane", null, "9876543210", "456 Elm St");
		// Verify the last name remains unchanged
		assertEquals("Doe", service.contacts.get("12345").getLastName());
	}

	@Test
	void updateContact_NullPhone_DoesNotUpdatePhone() {
		// Test: Updating a contact with a null phone number should not change the phone number
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
		service.updateContact("12345", "Jane", "Smith", null, "456 Elm St");
		// Verify the phone number remains unchanged
		assertEquals("1234567890", service.contacts.get("12345").getPhone());
	}

	@Test
	void updateContact_NullAddress_DoesNotUpdateAddress() {
		// Test: Updating a contact with a null address should not change the address
		ContactService service = new ContactService();
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
		service.addContact(contact);
		service.updateContact("12345", "Jane", "Smith", "9876543210", null);
		// Verify the address remains unchanged
		assertEquals("123 Main St", service.contacts.get("12345").getAddress());
	}

}
