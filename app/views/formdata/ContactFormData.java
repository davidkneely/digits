package views.formdata;

import models.Contact;
import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;

/**
 * The backing class for the contact form data.
 */
public class ContactFormData {

  private static final int NUM_TELEPHONE_DIGITS = 12;

  /** The first name. */
  public String firstName;
  /** The last name. */
  public String lastName;
  /** The telephone number in xxx-xxx-xxxx. */
  public String telephone;
  /** The id. */
  public long id;
  /** The telephone type. */
  public String telephoneType;
  /** The image id **/
  public long imageId;

  /**
   * Creates list of diet types.
   */
  public List<String> dietTypes = new ArrayList<String>();

  /**
   * Public no-arg constructor required by play.
   */
  public ContactFormData() {
    // no arg constructor.
  }

  /**
   * Constructs a ContactFormData from a contact.
   * @param contact The contact.
   */
  public ContactFormData(Contact contact) {
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.telephone = contact.getTelephone();
    this.id = contact.getId();
    this.telephoneType = contact.getTelephoneType().getTelephoneType();
    this.dietTypes = contact.getDietTypesList();
    this.imageId = contact.getImageId();

  }

  /**
   * Creates test data during initialization.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone.
   * @param telephoneType The telephone type.
   * @param dietTypes The diet type.
   */
  public ContactFormData(String firstName, String lastName, String telephone,
                         String telephoneType, ArrayList<String> dietTypes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.telephone = telephone;
    this.telephoneType = telephoneType;
    this.dietTypes = dietTypes;
  }

  /**
   * Validates the input in the contact form.
   * @return The list of errors if there are any.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }
    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone is required."));
    }
    if (telephone.length() != NUM_TELEPHONE_DIGITS) {
      errors.add(new ValidationError("telephone", "Telephone must be xxx-xxx-xxxx."));
    }
    if (!TelephoneTypes.isType(telephoneType)) {
      errors.add(new ValidationError("telephoneType", "Telephone type is invalid."));
    }

    // Diet Types are optional, but if supplied must exist in database.
    if (dietTypes.size() > 0) {
      for (String dietType : dietTypes) {
        if (DietTypes.findDietTypes(dietType) == null) {
          errors.add(new ValidationError("dietTypes", "Unknown dietType: " + dietType + "."));
        }
      }
    }

    return errors.isEmpty() ? null : errors;

  }

  /**
   * Returns the id.
   * @return The id.
   */
  public long getId() {
    return id;
  }

}