package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates TelephoneType to hold the type of telephone.
 */
public class TelephoneType {
  private long id;
  private String telephoneType;
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
   * Gets the telephone type.
   * @return The telephone type.
   */
  public String getTelephoneType() {
    return telephoneType;
  }

  /**
   * Sets the telephone type.
   * @param telephoneType The telephone type.
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
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
   * Constructs a new instance with the passed telephone type.
   * @param telephoneType The telephone type.
   */
  public TelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }
}
