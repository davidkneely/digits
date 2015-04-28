package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates TelephoneType to hold the type of telephone.
 */
@Entity
public class TelephoneType extends Model {
  @Id
  private long id;
  private String telephoneType;
  @OneToMany(mappedBy = "telephoneType")
  List<Contact> contacts = new ArrayList<>();

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, TelephoneType> find() {
    return new Finder<Long, TelephoneType>(Long.class, TelephoneType.class);
  }

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
