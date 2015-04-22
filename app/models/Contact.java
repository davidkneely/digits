package models;

import java.util.ArrayList;

/**
 * Mock up model for the backend database.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  private long id;
  private String telephoneType;
  private ArrayList<String> dietTypes;

  /**
   * Creates a contact from a contact instance.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone.
   * @param id The id.
   * @param telephoneType The telephone type.
   * @param dietTypes The diet type.
   */
  public Contact(String firstName, String lastName, String telephone,
                 long id, String telephoneType, ArrayList<String> dietTypes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.id = id;
    this.telephoneType = telephoneType;
    this.dietTypes = dietTypes;
  }

  /**
   * Returns the first name.
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns the last name.
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }
  /**
   * Returns the telephone number.
   * @return The telephone number.
   */
  public String getTelephone() {
    return telephone;
  }

  /**
   * Returns the id.
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns the telephone type.
   * @return The telephone type.
   */
  public String getTelephoneType() {
    return telephoneType;
  }

  /**
   * Returns the diet types.
   * @return The diet types.
   */
  public ArrayList<String> getDietTypes() {
    return dietTypes;
  }
}
