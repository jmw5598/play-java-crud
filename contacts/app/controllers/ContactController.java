package controllers;

import javax.inject.Inject;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import play.libs.Json;
import service.ContactService;
import model.Contact;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ContactController extends Controller {

    private ContactService contactService;

    @Inject()
    public ContactController(ContactService contactService) {
      this.contactService = contactService;
    }

    public Result index() {
        return ok(Json.toJson(contactService.findAll()));
    }

    public Result createContact() {
      JsonNode json = request().body().asJson();
      Contact contact = contactService.add(Json.fromJson(json, Contact.class));
      return ok(Json.toJson(contact));
    }

    public Result getContactById(Integer id) {
      return ok(Json.toJson(contactService.findById(id)));
    }

    public Result updateContact() {
      JsonNode json = request().body().asJson();
      Contact contact = contactService.update(Json.fromJson(json, Contact.class));
      return ok(Json.toJson(contact));
    }

    public Result deleteContact(Integer id) {
      Contact contact = contactService.remove(id);
      return ok(Json.toJson(contact));
    }

}
