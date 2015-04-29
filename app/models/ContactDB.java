package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * A mockup internal in-memory data structure for contacts.
 */
public class ContactDB {

  //private static Map<Long, Contact> contacts = new HashMap<>();
  //private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();
  //private static Map<String, DietType> dietTypes = new HashMap<>();
  //private static long currentId = 1;

  /**
   * Creates a Contact instance from form data and adds it to internal contacts DB.
   * If form ID was zero, create an ID for this new contact before saving. Otherwise update the pre-existing entry.
   * @param formData The form data.
   */
//  public static void addContact(ContactFormData formData) {
//
//    TelephoneType telephoneType = getTelephoneType(formData.telephoneType);
//    List<DietType> dietTypes = new ArrayList<>();
//    for (String dietString : formData.dietTypes) {
//      dietTypes.add(getDietType(dietString));
//    }
//    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone,
//        telephoneType, dietTypes);
//
//    // Make relationships bi-directional.
//    telephoneType.addContact(contact);
//    for (DietType dietType : dietTypes) {
//      dietType.addContact(contact);
//    }
//
//    contact.save();
//  }

  /**
   * Creates a Contact instance from form data and adds it to internal contacts DB.
   * If form ID was zero, create an ID for this new contact before saving. Otherwise update the pre-existing entry.
   * @param formData The form data.
   */
  public static void addContact(ContactFormData formData) {

    TelephoneType telephoneType = getTelephoneType(formData.telephoneType);
    List<DietType> dietTypes = new ArrayList<>();
    for (String dietString : formData.dietTypes) {
      dietTypes.add(getDietType(dietString));
    }

    Contact contact = (formData.id == 0) ? new Contact(formData.firstName, formData.lastName, formData.telephone,
        telephoneType, dietTypes, formData.data, formData.imageName) : Contact.find().byId(formData.id);
    contact.setFirstName(formData.firstName);
    contact.setLastName(formData.lastName);
    contact.setTelephone(formData.telephone);
    contact.setTelephoneType(telephoneType);
    contact.setDietTypes(dietTypes);
    contact.setData(formData.data);
    contact.setImageName(formData.imageName);
    contact.setImageName("testImageName.png");

    // Make relationships bi-directional.
    telephoneType.addContact(contact);
    for (DietType dietType : dietTypes) {
      dietType.addContact(contact);
    }

    contact.save();
  }

  /**
   * Updates db with passed telephone type.
   * @param telephoneType The telephone type.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneType.save();
  }

  /**
   * Updates db with passed diet type.
   * @param dietType The diet type.
   */
  public static void addDietType(DietType dietType) {
    dietType.save();
  }

  /**
   * Returns the telephone type associate with typeString or throws runtime exception if not found.
   * @param typeString The telephone type.
   * @return The telephone instance if found.
   */
  public static TelephoneType getTelephoneType(String typeString) {
    TelephoneType telephoneType = TelephoneType.find().where().eq("telephoneType", typeString).findUnique();
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
  public static DietType getDietType(String typeString) {
    DietType dietType = DietType.find().where().eq("dietType", typeString).findUnique();
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
    Contact contact = Contact.find().byId(id);
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
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("Could not find the contact with associated id.");
    }
    contact.delete();
  }

  /**
   * Returns the list of contacts.
   * @return The contact list.
   */
  public static List<Contact> getContacts() {
    return Contact.find().all();
  }

}
