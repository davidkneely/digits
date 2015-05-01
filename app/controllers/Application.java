package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.DietTypes;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.NewContact;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

import java.io.File;
import java.util.Map;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   *
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Handles the request to get the new contact page.
   *
   * @param id The id.
   * @return The new contact page.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
    Map<String, Boolean> dietTypeMap = DietTypes.getTypes(data.dietTypes);
    System.out.println(formData.get().imageName);
    return ok(NewContact.render(formData, telephoneTypeMap, dietTypeMap));
  }

  /**
   * Handles request to post form data from the new contacts page.
   *
   * @return The page with the form data that was just posted.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    if (formData.hasErrors()) {
      System.out.println("Errors Found.");
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes();
      Map<String, Boolean> dietTypeMap = DietTypes.getTypes();
      return badRequest(NewContact.render(formData, telephoneTypeMap, dietTypeMap));
    }
    else {

      MultipartFormData body = request().body().asMultipartFormData();
      FilePart picture = body.getFile("image");
      if (picture != null) {
        String fileName = picture.getFilename();
        String contentType = picture.getContentType();
        File file = picture.getFile();
        System.out.printf("Got image: %s %n", fileName);
      } else {
        System.out.printf("Error getting image");
      }

      ContactFormData data = formData.get();
      ContactDB.addContact(data);
      System.out.printf("Got data: %s, %s, %s %s %s %n", data.firstName, data.lastName,
          data.telephone, data.telephoneType, data.dietTypes);
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
      Map<String, Boolean> dietTypeMap = DietTypes.getTypes(data.dietTypes);
      return ok(NewContact.render(formData, telephoneTypeMap, dietTypeMap));
    }
  }

  /**
   * Handles request to delete contact from in-memory database.
   *
   * @param id The id.
   * @return The Index page.
   */
  public static Result deleteContact(long id) {
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
  }

}
