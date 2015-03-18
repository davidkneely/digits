package models;

/**
 * Mock up model for the backend database.
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  private long id;

  /**
   * Creates a contact from a contact instance.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone.
   * @param id The id.
   */
  public Contact(String firstName, String lastName, String telephone, long id) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.id = id;
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
}
