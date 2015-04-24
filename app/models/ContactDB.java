package models;

import views.formdata.ContactFormData;
import views.formdata.TelephoneTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A mockup internal in-memory data structure for contacts.
 */
public class ContactDB {

  private static Map<Long, Contact> contacts = new HashMap<>();
  private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();
  private static Map<String, DietType> dietTypes = new HashMap<>();
  private static long currentId = 1;

  /**
   * Creates a Contact instance from form data and adds it to internal contacts DB.
   * If form ID was zero, create an ID for this new contact before saving. Otherwise update the pre-existing entry.
   * @param formData The form data.
   */
  public static void addContact(ContactFormData formData) {
    long idVal = (formData.id == 0) ? currentId++ : formData.id;
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone,
        idVal, formData.telephoneType, formData.dietTypes);
    contacts.put(idVal, contact);
  }

  /**
   * Updates db with passed telephone type.
   * @param telephoneType The telephone type.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneTypes.put(telephoneType.getTelephoneType(), telephoneType);
  }

  /**
   * Updates db with passed diet type.
   * @param dietType The diet type.
   */
  public static void addDietType(DietType dietType) {
    dietTypes.put(dietType.getDietType(), dietType);
  }

  /**
   * Returns the telephone type associate with typeString or throws runtime exception if not found.
   * @param typeString The telephone type.
   * @return The telephone instance if found.
   */
  public TelephoneType getTelephoneType(String typeString) {
    TelephoneType telephoneType = telephoneTypes.get(typeString);
    if (telephoneType == null) {
      throw new RuntimeException("Illegal telephone type " + typeString);
    }
    return telephoneType;
  }

  /**
   * Returns hte diet type associated with teh typeString or throws runtime exepction if not found.
   * @param typeString The diet type.
   * @return The diet type instance if found.
   */
  public DietType getDietType(String typeString) {
    DietType dietType = dietTypes.get(typeString);
    if (dietType == null) {
      throw new RuntimeException("Illegal diet type " + typeString);
    }
    return dietType;
  }

  /**
   * Returns the contact associated with id, or throws a RuntimeException if not found.
   * @param id The id.
   * @return The contact.
   */
  public static Contact getContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Could not find the contact with associated id.");
    }
    return contact;
  }

  /**
   * Deletes a contact from the in-memory database with a matching ID value.
   *
   * @param id The ID value of the contact to delete.
   */
  public static void deleteContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Could not find the contact with associated id.");
    }
    contacts.remove(id);
  }

  /**
   * Returns the list of contacts.
   * @return The contact list.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }

}
