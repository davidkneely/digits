package models;

/**
 * Mock up model for the backend database.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;

  /**
   * Creates a contact from a contact instance.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone.
   */
  public Contact(String firstName, String lastName, String telephone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
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
}
