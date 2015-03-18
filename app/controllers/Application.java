package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.NewContact;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Handles the request to get the new contact page.
   * @return The new contact page.
   * @param id The id.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    return ok(NewContact.render(formData));
  }

  /**
   * Handles the request to delete a contact.
   * @param id The contact id.
   */
  public static Result deleteContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    ContactDB.deleteContact(data);
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Handles request to post form data from the new contacts page.
   * @return The page with the form data that was just posted.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors Found.");
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContact(data);
      System.out.printf("Got data: %s, %s, %s %n", data.firstName, data.lastName, data.telephone);
      return ok(NewContact.render(formData));
    }
  }

}