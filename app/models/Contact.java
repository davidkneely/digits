package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock up model for the backend database.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  private long id;
  private TelephoneType telephoneType;
  private List<DietType> dietTypes;

  /**
   * Sets the first name.
   * @param firstName The first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Sets the last name.
   * @param lastName The last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Sets the telephone.
   * @param telephone The telephone.
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  /**
   * Sets the id.
   * @param id The id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Sets the telephone type.
   * @param telephoneType The telephone type.
   */
  public void setTelephoneType(TelephoneType telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Sets the diet type.
   * @param dietTypes The diet type.
   */
  public void setDietTypes(ArrayList<DietType> dietTypes) {
    this.dietTypes = dietTypes;
  }

  /**
   * Creates a contact from a contact instance.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone.
   * @param id The id.
   * @param telephoneType The telephone type.
   * @param dietTypes The diet type.
   */
  public Contact(String firstName, String lastName, String telephone, long id,
                 TelephoneType telephoneType, List<DietType> dietTypes) {
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
  public TelephoneType getTelephoneType() {
    return telephoneType;
  }

  /**
   * Gets the diet type.
   * @return The diet type.
   */
  public List<DietType> getDietTypes() {
    return dietTypes;
  }

  /**
   * Returns a single string of comma delimited diet types.
   * @return The diet types as a string.
   */
  public String getDietTypeString() {
    String diets = "";
    for (DietType diet : dietTypes) {
      diets += diet.getDietType() + ", ";
    }
    return diets.substring(0, (diets.length() == 0 ? 0 : (diets.length() - 1)));
  }

  /**
   * Returns a list of diet type strings.
   * @return The list of diet type strings for this contact.
   */
  public List<String> getDietTypesList() {
    List<String> dietList = new ArrayList<>();
    for (DietType dietType : this.dietTypes) {
      dietList.add(dietType.getDietType());
    }
    return dietList;
  }
}
