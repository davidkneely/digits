import models.ContactDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

/**
 * Initialize system with four contacts.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);
    ContactDB.addContact(new ContactFormData("David", "Neely", "808-111-1111", "Mobile"));
    ContactDB.addContact(new ContactFormData("Jason", "Neely", "808-211-1111", "Home"));
    ContactDB.addContact(new ContactFormData("James", "Neely", "808-311-1111", "Work"));
    ContactDB.addContact(new ContactFormData("Carolene", "Neely", "808-411-1111", "Mobile"));
  }
}
