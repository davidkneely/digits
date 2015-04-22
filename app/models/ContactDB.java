package models;

import views.formdata.ContactFormData;

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

    TelephoneType telephoneType = getTelephoneType(formData.telephoneType);
    List<DietType> dietTypes = new ArrayList<>();
    for (String dietString : formData.dietTypes) {
      dietTypes.add(getDietType(dietString));
    }

    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone,
        idVal, telephoneType, dietTypes);
    contacts.put(idVal, contact);
  }

  /**
   * Updates db with a new telephone type.
   * @param telephoneType The telephone type.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneTypes.put(telephoneType.getTelephoneType(), telephoneType);
  }

  /**
   * Update db with new diet type.
   * @param dietType The diet type.
   */
  public static void addDietType(DietType dietType) {
    dietTypes.put(dietType.getDietType(), dietType);
  }

  /**
   * Returns the TelephoneType associated wtih the typeString or throws RuntimeExpection if not found.
   * @param typeString The telephone type.
   * @return The telephone type.
   */
  public static TelephoneType getTelephoneType(String typeString) {
    TelephoneType telephoneType = telephoneTypes.get(typeString);
    if(telephoneType == null) {
      throw new RuntimeException("Illegal telephone type" + typeString);
    }
    return telephoneType;
  }

  /**
   * Returns the DietType associated with the typeStrong or throws RuntimeException if not found.
   * @param typeString The diet type.
   * @return The diet type.
   */
  public static DietType getDietType(String typeString) {
    DietType dietType = dietTypes.get(typeString);
    if(dietType == null) {
      throw new RuntimeException("Illegal diet type" + typeString);
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
