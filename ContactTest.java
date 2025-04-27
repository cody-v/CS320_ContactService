/**
 * ContactTest.java
 *
 * Author: Cody Vachon
 * Date: April 10, 20225
 *
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

	@Test
	void contactConstructor_ValidInput_CreatesContact() {
		// Test valid input to the Contact constructor
		Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

		// Verify fields are set correctly
		assertEquals("12345", contact.getContactID());
		assertEquals("John", contact.getFirstName());
		assertEquals("Doe", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());
	}

	@Test
	void contactConstructor_InvalidId_ThrowsException() {
		// Test invalid IDs that are too long or null
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
		assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
	}

	@Test
	void contactConstructor_InvalidFirstName_ThrowsException() {
		// Test invalid first names that are too long or null
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "Johnnnnnnnn", "Doe", "1234567890", "123 Main St"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", null, "Doe", "1234567890", "123 Main St"));
	}

	@Test
	void contactConstructor_InvalidLastName_ThrowsException() {
		// Test invalid last names that are too long or null
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doeeeeeeeee", "1234567890", "123 Main St"));
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", null, "1234567890", "123 Main St"));
	}

	@Test
	void contactConstructor_InvalidPhone_ThrowsException() {
		// Test invalid phone numbers that have incorrect lengths or non-numeric values
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "123456789", "123 Main St")); // Too short
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "12345678901", "123 Main St")); // Too long
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", null, "123 Main St")); // Null
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "abcdefghij", "123 Main St")); // Non-numeric
	}

	@Test
	void contactConstructor_InvalidAddress_ThrowsException() {
		// Test invalid address that's too long
		assertThrows(IllegalArgumentException.class, () -> new Contact("12345", "John", "Doe", "1234567890",
				"123 Main Stttttttttttttttttttttttttttttttttttttttttttttttttttttttttt")); // Address too long
	}
}
