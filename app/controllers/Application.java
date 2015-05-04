package controllers;

import models.ContactDB;
import models.Image;
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

import static play.data.Form.form;

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
   * @param id The id.
   * @return The new contact page.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
    Map<String, Boolean> dietTypeMap = DietTypes.getTypes(data.dietTypes);
    return ok(NewContact.render(formData, telephoneTypeMap, dietTypeMap));
  }

  /**
   * Handles request to post form data from the new contacts page.
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








      /* Retrieves image from form */

      MultipartFormData body = request().body().asMultipartFormData();
      FilePart picture = body.getFile("image");
      String fileName = "";
      String contentType = "";
      File file = null;
      if (picture != null) {
        fileName = picture.getFilename();
        contentType = picture.getContentType();
        file = picture.getFile();
      } else {
        System.out.printf("Error getting image");
      }

      Image image = new Image(fileName, file);

      ContactFormData data = formData.get();
      ContactDB.addContact(data);

      System.out.printf("Got data: %s, %s, %s %s %s %n", data.firstName, data.lastName,
          data.telephone, data.telephoneType, data.dietTypes);
      Map<String, Boolean> telephoneTypeMap = TelephoneTypes.getTypes(data.telephoneType);
      Map<String, Boolean> dietTypeMap = DietTypes.getTypes(data.dietTypes);
      return ok(NewContact.render(formData, telephoneTypeMap, dietTypeMap));
    }
  }

  public static Result getImage(long id) {
    Image image = Image.find.byId(id);

    if (image != null) {

      /*** here happens the magic ***/
      return ok(image.data).as("image");
      /************************** ***/

    } else {
      flash("error", "Picture not found.");
      return redirect(routes.Application.index());
    }
  }

//  public static Result uploadImage() {
//    Form<UploadImageForm> form = form(UploadImageForm.class).bindFromRequest();
//
//    if (form.hasErrors()) {
//      return badRequest(index.render(
//          form,
//          Image.find.all()
//      ));
//
//    } else {
//      new Image(
//          form.get().image.getFilename(),
//          form.get().image.getFile()
//      );
//
//      flash("success", "File uploaded.");
//      return redirect(routes.Application.index());
//    }
//  }
//
//  public static class UploadImageForm {
//    public Http.MultipartFormData.FilePart image;
//
//    public String validate() {
//      Http.MultipartFormData data = request().body().asMultipartFormData();
//      image = data.getFile("image");
//
//      if (image == null) {
//        return "File is missing.";
//      }
//
//      return null;
//    }
//  }

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
