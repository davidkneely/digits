package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * A mockup internal in-memory data structure for contacts.
 */
public class ContactDB {
  public static List<Contact> contacts = new ArrayList<>();

  /**
   * Creates a Contact instance from form data and adds it to internal contacts DB.
   * @param formData The form data.
   */
  public static void addContact(ContactFormData formData){
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone);
    contacts.add(contact);
  }

  /**
   * Returns the list of contacts.
   * @return The contact list.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }
}
