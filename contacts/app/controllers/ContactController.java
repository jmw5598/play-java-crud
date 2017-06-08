package controllers;

import play.mvc.*;
import play.libs.Json;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ContactController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(Json.toJson("returning all contacts"));
    }

    public Result createContact() {
      System.out.println("created contact");
      return ok(Json.toJson("created new contact"));
    }

    public Result getContactById(Integer id) {
      return ok(Json.toJson("retuing contact with id: " + id));
    }

    public Result updateContact(Integer id) {
      System.out.println("updated contact");
      return ok(Json.toJson("updated contact"));
    }

    public Result deleteContact(Integer id) {
      System.out.println("deleted contact");
      return ok(Json.toJson("deleted contact"));
    }

}
