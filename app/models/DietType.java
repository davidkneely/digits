package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates DietType to hold the diet types.
 */
public class DietType {
  private long id;
  private String dietType;
  List<Contact> contacts = new ArrayList<>();

  /**
   * Gets the id.
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id.
   * @param id The id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the diet type.
   * @return The diet type.
   */
  public String getDietType() {
    return dietType;
  }

  /**
   * Sets the diet type.
   * @param dietType The diet type.
   */
  public void setDietType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * Gets the contacts.
   * @return The contacts.
   */
  public List<Contact> getContacts() {
    return contacts;
  }

  /**
   * Sets the contacts.
   * @param contacts The contacts.
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Adds the contact.
   * @param contact The contact.
   */
  public void addContact(Contact contact) {
    this.contacts.add(contact);
  }

  /**
   * Constructs a new instance with the passed diet type.
   * @param dietType The diet type.
   */
  public DietType(String dietType) {
    this.dietType = dietType;
  }
}
