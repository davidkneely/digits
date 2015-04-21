import models.ContactDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

import java.util.ArrayList;

/**
 * Initialize system with four contacts.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);
    ArrayList<String> dietType = new ArrayList<String>();
    ContactDB.addContact(new ContactFormData("David", "Neely", "808-111-1111", "Mobile", dietType));
    ContactDB.addContact(new ContactFormData("Jason", "Neely", "808-211-1111", "Home", dietType));
    ContactDB.addContact(new ContactFormData("James", "Neely", "808-311-1111", "Work", dietType));
    ContactDB.addContact(new ContactFormData("Carolene", "Neely", "808-411-1111", "Mobile", dietType));
  }
}
