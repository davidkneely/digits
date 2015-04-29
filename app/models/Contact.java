package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Mock up model for the backend database.
 */
@Entity
public class Contact extends Model {
  private String firstName;
  private String lastName;
  private String telephone;
  @Id
  private long id;
  @ManyToOne(cascade = CascadeType.PERSIST)
  private TelephoneType telephoneType;
  @ManyToMany(cascade = CascadeType.PERSIST)
  private List<DietType> dietTypes;
  @Lob
  private byte[] data;
  private String imageName;

  /**
   * Gets image data.
   * @return The image data.
   */
  public byte[] getData() {
    return data;
  }

  /**
   * Sets the image data.
   * @param data The image data.
   */
  public void setData(byte[] data) {
    this.data = data;
  }

  /**
   * Gets the image name.
   * @return The image name.
   */
  public String getImageName() {
    return imageName;
  }

  /**
   * Sets the image name.
   * @param imageName The image name.
   */
  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

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
  public void setDietTypes(List<DietType> dietTypes) {
    this.dietTypes = dietTypes;
  }

  /**
   * Creates a contact from a contact instance.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone.
   * @param telephoneType The telephone type.
   * @param dietTypes The diet type.
   */
  public Contact(String firstName, String lastName, String telephone,
                 TelephoneType telephoneType, List<DietType> dietTypes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.dietTypes = dietTypes;
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
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
