package controllers;

import javax.inject.Inject;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.*;
import play.libs.Json;
import service.ContactService;
import model.Contact;
import util.ResponseBuilder;
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
      if(contact == null) {
        return badRequest(
          ResponseBuilder.build("Error creating new contact", false)
        );
      }
      return ok(ResponseBuilder.build(contact, true));
    }

    public Result getContactById(Integer id) {
      Contact contact = contactService.findById(id);
      if(contact == null) {
        return notFound(
          ResponseBuilder.build("Unable to find contact with id : " + id, false)
        );
      }
      return ok(ResponseBuilder.build(contact, true));
    }

    public Result updateContact() {
      JsonNode json = request().body().asJson();
      Contact contact = contactService.update(Json.fromJson(json, Contact.class));
      if(contact == null) {
        return badRequest(
          ResponseBuilder.build("Error while updating contact", false)
        );
      }
      return ok(ResponseBuilder.build(contact, true));
    }

    public Result deleteContact(Integer id) {
      Contact contact = contactService.remove(id);
      if(contact == null) {
        return badRequest(
          ResponseBuilder.build("Error while deleting contact with id: " + id, false)
        );
      }
      return ok(ResponseBuilder.build(contact, true));
    }

}
